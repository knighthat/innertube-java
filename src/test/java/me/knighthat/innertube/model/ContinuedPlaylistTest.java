package me.knighthat.innertube.model;

import me.knighthat.innertube.internal.response.GranularParser;
import me.knighthat.innertube.response.MusicPlaylistShelfRenderer;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

class ContinuedPlaylistTest {

// START: Static fields/functions
    @NotNull
    private static final ClassLoader LOADER = ContinuedPlaylistTest.class.getClassLoader ();
// END: Static fields/functions

    @Test
    void testPlaylistContinuedMusicPlaylistShelfRendererContent1() {
        final String fileName = "ytm/browse/playlist_continued_musicPlaylistShelfRenderer_content_1.json";
        Executable executable = () -> {
            try (
                    InputStream inStream = LOADER.getResourceAsStream ( fileName ) ;
                    InputStreamReader reader = new InputStreamReader ( inStream )
            ) {
                List<? extends MusicPlaylistShelfRenderer.Content> renderer = GranularParser.musicPlaylistShelfRendererContent ( reader );

                ContinuedPlaylist continuedPlaylist = ContinuedPlaylist.from ( renderer );
                Assertions.assertNotNull ( continuedPlaylist.getContinuation () );
                Assertions.assertEquals (
                        "4qmFsgKFARIkVkxQTE1wMUJaRjg3T0twU3J1Z29aZElydmZsMFlBN2t2MUxnGjhlaDlRVkRwRFRXZENTV2hCZDAxcVJYbE5SVVpFVFZSbmVrNVZWWHBTVkdjMWtnRURDTG9FOEFFQZoCIlBMTXAxQlpGODdPS3BTcnVnb1pkSXJ2ZmwwWUE3a3YxTGc%3D",
                        continuedPlaylist.getContinuation ()
                );
                Assertions.assertFalse ( continuedPlaylist.getSongs ().isEmpty () );
                Assertions.assertEquals ( 100, continuedPlaylist.getSongs ().size () );
            }
        };

        Assertions.assertDoesNotThrow (
                executable,
                "failed to instantiate InnertubePlaylist with " + fileName
        );
    }

    @Test
    void testPlaylistContinuedMusicPlaylistShelfRendererContent2() {
        final String fileName = "ytm/browse/playlist_continued_musicPlaylistShelfRenderer_content_2.json";
        Executable executable = () -> {
            try (
                    InputStream inStream = LOADER.getResourceAsStream ( fileName ) ;
                    InputStreamReader reader = new InputStreamReader ( inStream )
            ) {
                List<? extends MusicPlaylistShelfRenderer.Content> renderer = GranularParser.musicPlaylistShelfRendererContent ( reader );

                ContinuedPlaylist continuedPlaylist = ContinuedPlaylist.from ( renderer );
                Assertions.assertNotNull ( continuedPlaylist.getContinuation () );
                Assertions.assertEquals (
                        "4qmFsgKFARIkVkxQTE1wMUJaRjg3T0twU3J1Z29aZElydmZsMFlBN2t2MUxnGjhlaDlRVkRwRFMzZERTV2hCZDFGVWFFUk9NRlpEVWxSVk1VNVVSVFZOZWswMWtnRURDTG9FOEFFQZoCIlBMTXAxQlpGODdPS3BTcnVnb1pkSXJ2ZmwwWUE3a3YxTGc%3D",
                        continuedPlaylist.getContinuation ()
                );
                Assertions.assertFalse ( continuedPlaylist.getSongs ().isEmpty () );
                Assertions.assertEquals ( 100, continuedPlaylist.getSongs ().size () );
            }
        };

        Assertions.assertDoesNotThrow (
                executable,
                "failed to instantiate InnertubePlaylist with " + fileName
        );
    }
}