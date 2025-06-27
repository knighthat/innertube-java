package me.knighthat.innertube.model;

import lombok.EqualsAndHashCode;
import lombok.Value;
import me.knighthat.innertube.Constants;
import me.knighthat.innertube.PageType;
import me.knighthat.innertube.PublicAccessible;
import me.knighthat.innertube.response.*;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@Value
public class InnertubeArtist extends InnertubeItem implements PublicAccessible {

// START: Static fields/functions
    @Contract("null->null")
    private static @Nullable InnertubeItem parse( @Nullable MusicTwoRowItemRenderer renderer ) {
        if ( renderer == null )
            return null;

        InnertubeItem result = null;

        try {
            Endpoint.Browse browse = renderer.getTitle()
                                             .getRuns()
                                             .get( 0 )
                                             .getNavigationEndpoint()
                                             .getBrowseEndpoint();

            String pageType = browse.getBrowseEndpointContextSupportedConfigs()
                                    .getBrowseEndpointContextMusicConfig().
                                    getPageType();
            result = switch ( pageType ) {
                // TODO: Add parser for Videos and Live performances
                case PageType.ARTIST -> InnertubeArtist.from( renderer );
                case PageType.ALBUM -> InnertubeAlbum.from( renderer );
                case PageType.PLAYLIST -> InnertubePlaylist.from( renderer );
                default -> null;
            };

        } catch ( NullPointerException ignored ) {
        }

        return result;
    }

    public static @NotNull InnertubeArtist from( @NotNull MusicTwoRowItemRenderer renderer ) {
        return new InnertubeArtist(
                renderer,
                null,
                null,
                ItemUtils.getFirstText( renderer.getSubtitle() ),
                Collections.emptyList(),
                null
        );
    }

    public static @NotNull InnertubeArtist from( @NotNull BrowseResponse response ) {
        BrowseResponse.Header.MusicImmersiveHeaderRenderer header = Objects.requireNonNull( response.getHeader() )
                                                                           .getMusicImmersiveHeaderRenderer();
        Button.Subscribe subscribeButton = Objects.requireNonNull(
                header.getSubscriptionButton()
                      .getSubscribeButtonRenderer()
        );
        List<? extends SectionListRenderer.Content> contents = response.getContents()
                                                                       .getSingleColumnBrowseResultsRenderer()
                                                                       .getTabs()
                                                                       .get( 0 )
                                                                       .getTabRenderer()
                                                                       .getContent()
                                                                       .getSectionListRenderer()
                                                                       .getContents();

        List<Section> sections = new ArrayList<>( 8 );
        String description = null;
        // Each item only contains 1 thing to process,
        // if it is processed, move to next item and skip
        // the rest of the checks below
        for ( SectionListRenderer.Content content : contents ) {
            MusicShelfRenderer musicSection = content.getMusicShelfRenderer();
            if ( musicSection != null ) {
                Endpoint.Browse browse = musicSection.getBottomEndpoint() == null
                        ? null
                        : musicSection.getBottomEndpoint().getBrowseEndpoint();

                sections.add(
                        new Section(
                                ItemUtils.getFirstText( musicSection.getTitle() ),
                                browse != null ? browse.getBrowseId() : null,
                                browse != null ? browse.getParams() : null,
                                musicSection.getContents()
                                            .stream()
                                            .map( MusicShelfRenderer.Content::getMusicResponsiveListItemRenderer )
                                            .map( InnertubeSong::from )
                                            .collect( Collectors.toUnmodifiableList() )
                        )
                );
                continue;
            }

            SectionListRenderer.Content.MusicDescriptionShelfRenderer descriptionSection = content.getMusicDescriptionShelfRenderer();
            if ( descriptionSection != null ) {
                description = ItemUtils.getFirstText( descriptionSection.getDescription() );
                continue;
            }

            // This section contains Albums, Single & EPs, related Artists, and Playlists.
            MusicCarouselShelfRenderer mixSection = content.getMusicCarouselShelfRenderer();
            if ( mixSection != null ) {
                // Skip this section because 1 or all content isn't [MusicTwoRowItemRender]
                if ( mixSection.getContents().stream().anyMatch( sectionContent -> sectionContent.getMusicTwoRowItemRenderer() == null ) )
                    continue;

                MusicCarouselShelfRenderer.Header.MusicCarouselShelfBasicHeaderRenderer sectionHeader = mixSection.getHeader().getMusicCarouselShelfBasicHeaderRenderer();

                String browseId = null;
                String params = null;
                try {
                    Endpoint navEndpoint = Objects.requireNonNull(
                            sectionHeader.getTitle()
                                         .getRuns()
                                         .get( 0 )
                                         .getNavigationEndpoint()
                    );
                    Endpoint.Browse browse = Objects.requireNonNull(
                            navEndpoint.getBrowseEndpoint()
                    );

                    browseId = browse.getBrowseId();
                    params = browse.getParams();
                } catch ( NullPointerException ignored ) {
                }

                sections.add(
                        new Section(
                                ItemUtils.getFirstText( sectionHeader.getTitle() ),
                                browseId,
                                params,
                                mixSection.getContents()
                                          .stream()
                                          .map( MusicCarouselShelfRenderer.Content::getMusicTwoRowItemRenderer )
                                          .map( InnertubeArtist::parse )
                                          .filter( Objects::nonNull )
                                          .collect( Collectors.toUnmodifiableList() )
                        )
                );
            }
        }

        return new InnertubeArtist(
                subscribeButton.getChannelId(),
                ItemUtils.getFirstText( header.getTitle() ),
                Collections.unmodifiableList(
                        header.getThumbnail()
                              .getMusicThumbnailRenderer()
                              .getThumbnail()
                              .getThumbnails()
                ),
                ItemUtils.getFirstText( subscribeButton.getShortSubscriberCountText() ),
                ItemUtils.getFirstText( subscribeButton.getLongSubscriberCountText() ),
                ItemUtils.getFirstText( header.getMonthlyListenerCount() ),
                Collections.unmodifiableList( sections ),
                description
        );
    }
// END: Static fields/functions

    /**
     * Number of subscribers in <b>short</b> format:
     * - 10K
     * - 1M
     * <p>
     * Supports localization
     */
    @Nullable
    String shortNumSubscribers;

    /**
     * Number of subscribers in <b>long</b> format:
     * - 19.3M subscribers
     * <p>
     * Supports localization
     */
    @Nullable
    String longNumSubscribers;

    /**
     * Number of monthly listeners in short format:
     * - 324M monthly audience
     * <p>
     * Supports localization
     */
    @Nullable
    String shortNumMonthlyAudience;

    @NotNull
    @Unmodifiable
    List<Section> sections;

    @Nullable
    String description;

    public InnertubeArtist(
            @NotNull String id,
            @NotNull String name,
            @NotNull List<? extends Thumbnails.Thumbnail> thumbnails,
            @Nullable String shortNumSubscribers,
            @Nullable String longNumSubscribers,
            @Nullable String shortNumMonthlyAudience,
            @NotNull @Unmodifiable List<Section> sections,
            @Nullable String description
    ) {
        super( id, name, thumbnails );
        this.shortNumSubscribers = shortNumSubscribers;
        this.longNumSubscribers = longNumSubscribers;
        this.shortNumMonthlyAudience = shortNumMonthlyAudience;
        this.sections = sections;
        this.description = description;
    }

    public InnertubeArtist(
            @NotNull MusicTwoRowItemRenderer renderer,
            @Nullable String shortNumSubscribers,
            @Nullable String longNumSubscribers,
            @Nullable String shortNumMonthlyAudience,
            @NotNull @Unmodifiable List<Section> sections,
            @Nullable String description
    ) {
        super( renderer );
        this.shortNumSubscribers = shortNumSubscribers;
        this.longNumSubscribers = longNumSubscribers;
        this.shortNumMonthlyAudience = shortNumMonthlyAudience;
        this.sections = sections;
        this.description = description;
    }

    @Override
    public @NotNull String getShareUrl() {
        return Constants.YOUTUBE_URL + "channel/" + id;
    }

    @Override
    public @NotNull String getYouTubeMusicShareUrl() {
        return Constants.YOUTUBE_MUSIC_URL + "channel/" + id;
    }

    @Value
    static class Section {

        @NotNull
        String title;

        @Nullable
        String browseId;

        @Nullable
        String params;

        @NotNull
        List<? extends InnertubeItem> contents;
    }
}
