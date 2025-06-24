package me.knighthat.innertube.model;

import me.knighthat.innertube.internal.response.GranularParser;
import me.knighthat.innertube.response.MusicResponsiveListItemRenderer;
import me.knighthat.innertube.response.PlaylistPanelRenderer;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.InputStream;
import java.io.InputStreamReader;

class InnertubeSongTest {

// START: Static fields/functions
    @NotNull
    private static final ClassLoader LOADER = InnertubeSongTest.class.getClassLoader();
// END: Static fields/functions

    @Test
    void testBrowsePlaylistPanelVideoRendererConstructor() {
        final String fileName = "ytm/next/song_playlistPanelVideoRenderer.json";
        Executable executable = () -> {
            try (
                    InputStream inStream = LOADER.getResourceAsStream( fileName ) ;
                    InputStreamReader reader = new InputStreamReader( inStream )
            ) {
                PlaylistPanelRenderer.Content.VideoRenderer renderer = GranularParser.playlistPanelVideoRenderer( reader );

                InnertubeSong song = InnertubeSong.from( renderer );
                Assertions.assertEquals( "a_H0K9W984E", song.getId() );
                Assertions.assertEquals( "TU SANCHO", song.getName() );
                Assertions.assertFalse( song.getThumbnails()
                                            .isEmpty() );
                Assertions.assertEquals( "2:58", song.getDurationText() );
                Assertions.assertTrue( song.isExplicit() );
                Assertions.assertNotNull( song.getAlbum() );
                Assertions.assertFalse( song.getAuthors()
                                            .isEmpty() );
                Assertions.assertEquals( "Fuerza Regida", song.getAuthorsText() );
            }
        };

        Assertions.assertDoesNotThrow(
                executable,
                "failed to instantiate InnertubeSong with " + fileName
        );
    }

    @Test
    void testBrowseArtistSongMusicResponsiveListItemRendererConstructor() {
        final String fileName = "ytm/browse/artist_song_musicResponsiveListItemRenderer.json";
        Executable executable = () -> {
            try (
                    InputStream inStream = LOADER.getResourceAsStream( fileName ) ;
                    InputStreamReader reader = new InputStreamReader( inStream )
            ) {
                MusicResponsiveListItemRenderer renderer = GranularParser.musicResponsiveListItemRenderer( reader );

                InnertubeSong song = InnertubeSong.from( renderer );
                Assertions.assertEquals( "phLb_SoPBlA", song.getId() );
                Assertions.assertEquals( "Not Like Us", song.getName() );
                Assertions.assertFalse( song.getThumbnails()
                                            .isEmpty() );
                Assertions.assertEquals( "", song.getDurationText() );
                Assertions.assertTrue( song.isExplicit() );
                Assertions.assertNotNull( song.getAlbum() );
                Assertions.assertFalse( song.getAuthors()
                                            .isEmpty() );
                Assertions.assertEquals( "Kendrick Lamar", song.getAuthorsText() );
            }
        };

        Assertions.assertDoesNotThrow(
                executable,
                "failed to instantiate InnertubeSong with " + fileName
        );
    }

    @Test
    void testBrowseAlbumSongMusicResponsiveListItemRendererConstructor() {
        final String fileName = "ytm/browse/album_song_musicResponsiveListItemRenderer.json";
        Executable executable = () -> {
            try (
                    InputStream inStream = LOADER.getResourceAsStream( fileName ) ;
                    InputStreamReader reader = new InputStreamReader( inStream )
            ) {
                MusicResponsiveListItemRenderer renderer = GranularParser.musicResponsiveListItemRenderer( reader );

                InnertubeSong song = InnertubeSong.from( renderer );
                Assertions.assertEquals( "KEG7b851Ric", song.getId() );
                Assertions.assertEquals( "Taste", song.getName() );
                Assertions.assertTrue( song.getThumbnails()
                                           .isEmpty() );
                Assertions.assertEquals( "2:38", song.getDurationText() );
                Assertions.assertFalse( song.isExplicit() );
                Assertions.assertNull( song.getAlbum() );
                Assertions.assertTrue( song.getAuthors()
                                           .isEmpty() );
                Assertions.assertEquals( "", song.getAuthorsText() );
            }
        };

        Assertions.assertDoesNotThrow(
                executable,
                "failed to instantiate InnertubeSong with " + fileName
        );
    }

    @Test
    void testBrowsePlaylistSongMusicResponsiveListItemRendererConstructor() {
        final String fileName = "ytm/browse/playlist_song_musicResponsiveListItemRenderer.json";
        Executable executable = () -> {
            try (
                    InputStream inStream = LOADER.getResourceAsStream( fileName ) ;
                    InputStreamReader reader = new InputStreamReader( inStream )
            ) {
                MusicResponsiveListItemRenderer renderer = GranularParser.musicResponsiveListItemRenderer( reader );

                InnertubeSong song = InnertubeSong.from( renderer );
                Assertions.assertEquals( "jvipPYFebWc", song.getId() );
                Assertions.assertEquals( "Roundtable Rival", song.getName() );
                Assertions.assertFalse( song.getThumbnails()
                                            .isEmpty() );
                Assertions.assertEquals( "3:39", song.getDurationText() );
                Assertions.assertFalse( song.isExplicit() );
                Assertions.assertNull( song.getAlbum() );
                Assertions.assertFalse( song.getAuthors()
                                            .isEmpty() );
                Assertions.assertEquals( "Lindsey Stirling", song.getAuthorsText() );
            }
        };

        Assertions.assertDoesNotThrow(
                executable,
                "failed to instantiate InnertubeSong with " + fileName
        );
    }

    @Test
    void testSearchSongMusicResponsiveListItemRendererConstructor() {
        final String fileName = "ytm/search/song_musicResponsiveListItemRenderer.json";
        Executable executable = () -> {
            try (
                    InputStream inStream = LOADER.getResourceAsStream( fileName ) ;
                    InputStreamReader reader = new InputStreamReader( inStream )
            ) {
                MusicResponsiveListItemRenderer renderer = GranularParser.musicResponsiveListItemRenderer( reader );

                InnertubeSong song = InnertubeSong.from( renderer );
                Assertions.assertEquals( "w4nihuYVTW0", song.getId() );
                Assertions.assertEquals( "What is Love?", song.getName() );
                Assertions.assertFalse( song.getThumbnails()
                                            .isEmpty() );
                Assertions.assertEquals( "3:29", song.getDurationText() );
                Assertions.assertFalse( song.isExplicit() );
                Assertions.assertNotNull( song.getAlbum() );
                Assertions.assertFalse( song.getAuthors()
                                            .isEmpty() );
                Assertions.assertEquals( "TWICE", song.getAuthorsText() );
            }
        };

        Assertions.assertDoesNotThrow(
                executable,
                "failed to instantiate InnertubeSong with " + fileName
        );
    }
}