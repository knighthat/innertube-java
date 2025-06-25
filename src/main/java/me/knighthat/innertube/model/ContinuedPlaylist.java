package me.knighthat.innertube.model;

import lombok.Value;
import me.knighthat.innertube.response.MusicPlaylistShelfRenderer;
import me.knighthat.innertube.response.MusicResponsiveListItemRenderer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import java.util.ArrayList;
import java.util.List;

@Value
public class ContinuedPlaylist {

// START: Static fields/functions
    public static @NotNull ContinuedPlaylist from( @NotNull List<? extends MusicPlaylistShelfRenderer.Content> items ) {
        String continuation = null;
        List<InnertubeSong> songs = new ArrayList<>( items.size() );

        for ( MusicPlaylistShelfRenderer.Content item : items ) {
            MusicPlaylistShelfRenderer.Content.ContinuationItemRenderer continuationItem = item.getContinuationItemRenderer();
            if ( continuationItem != null )
                continuation = continuationItem.getContinuationEndpoint().getContinuationCommand().getToken();

            MusicResponsiveListItemRenderer musicItem = item.getMusicResponsiveListItemRenderer();
            if ( musicItem != null )
                songs.add( InnertubeSong.from( musicItem ) );
        }

        return new ContinuedPlaylist( continuation, songs );

    }
// END: Static fields/functions

    @Nullable
    String continuation;

    @NotNull
    @Unmodifiable
    List<InnertubeSong> songs;
}
