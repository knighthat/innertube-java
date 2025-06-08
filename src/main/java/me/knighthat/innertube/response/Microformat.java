package me.knighthat.innertube.response;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import me.knighthat.innertube.response.thumbnail.Thumbnails;

import java.util.List;

public interface Microformat {

    @NotNull
    Renderer getMicroformatDataRenderer();

    interface Renderer {

        @NotNull
        String getUrlCanonical();

        @Nullable
        String getTitle();

        @Nullable
        String getDescription();

        @Nullable
        Thumbnails getThumbnail();

        @Nullable
        String getSiteName();

        @Nullable
        String getAppName();

        @Nullable
        String getAndroidPackage();

        @Nullable
        String getIosAppStoreId();

        @Nullable
        String getIosAppArguments();

        @Nullable
        String getOgType();

        @Nullable
        String getUrlApplinksIos();

        @Nullable
        String getUrlApplinksAndroid();

        @Nullable
        String getUrlTwitterIos();

        @Nullable
        String getUrlTwitterAndroid();

        @Nullable
        String getTwitterCardType();

        @Nullable
        String getTwitterSiteHandle();

        @Nullable
        String getSchemaDotOrgType();

        @Nullable
        Boolean getNoindex();

        @Nullable
        Boolean getUnlisted();

        @Nullable
        Boolean getPaid();

        @Nullable
        Boolean getFamilySafe();

        @NotNull
        List<? extends String> getTags();

        @NotNull
        List<? extends String> getAvailableCountries();

        @Nullable
        PageOwnerDetails getPageOwnerDetails();

        @Nullable
        VideoDetails getVideoDetails();

        @NotNull
        List<? extends Link> getLinkAlternates();

        @Nullable
        String getViewCount();

        @Nullable
        String getPublishDate();

        @Nullable
        String getCategory();

        @Nullable
        String getUploadDate();

        interface PageOwnerDetails {

            @NotNull
            String getName();

            @NotNull
            String getExternalChannelId();

            @NotNull
            String getYoutubeProfileUrl();
        }

        interface VideoDetails {

            @NotNull
            String getExternalVideoId();

            @NotNull
            String getDurationSeconds();

            @NotNull
            String getDurationIso8601();
        }

        interface Link {

            @NotNull
            String getHrefUrl();

            @Nullable
            String getTitle();

            @Nullable
            String getAlternateType();
        }
    }
}
