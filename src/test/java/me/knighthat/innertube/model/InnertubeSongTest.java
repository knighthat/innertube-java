package me.knighthat.innertube.model;

import me.knighthat.innertube.internal.response.GranularParser;
import me.knighthat.innertube.response.MusicResponsiveListItemRenderer;
import me.knighthat.innertube.response.PlaylistPanelRenderer;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.IOException;
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
    void testBrowsePlaylistSongMusicResponsiveListItemRenderer1() {
        final String fileName = "ytm/browse/playlist_song_musicResponsiveListItemRenderer_1.json";
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
    void testBrowsePlaylistSongMusicResponsiveListItemRenderer2() {
        final String fileName = "ytm/browse/playlist_song_musicResponsiveListItemRenderer_2.json";
        try (
                InputStream inStream = LOADER.getResourceAsStream ( fileName ) ;
                InputStreamReader reader = new InputStreamReader ( inStream )
        ) {
            MusicResponsiveListItemRenderer renderer = GranularParser.musicResponsiveListItemRenderer ( reader );

            InnertubeSong song = InnertubeSong.from ( renderer );
            Assertions.assertEquals ( "5p_CJiP0KpY", song.getId () );
            Assertions.assertEquals ( "You Shook Me All Night Long (Live) (duet with Anastacia-Live from VH1 Divas)", song.getName () );
            Assertions.assertFalse ( song.getThumbnails ().isEmpty () );
            Assertions.assertEquals ( "3:52", song.getDurationText () );
            Assertions.assertFalse ( song.isExplicit () );

            // The correct value is "Divas Las Vegas" but since it
            // doesn't lead to anywhere, might as well not include it
            Assertions.assertNull ( song.getAlbum () );

            Assertions.assertFalse ( song.getAuthors ().isEmpty () );
            Assertions.assertNull ( song.getAuthors ().getFirst ().getNavigationEndpoint () );
            Assertions.assertEquals ( "Céline Dion & Anastacia", song.getAuthorsText () );
        } catch ( IOException e ) {
            Assertions.fail ( "Failed to read file %1$s because %2$s".formatted ( fileName, e.getMessage () ) );
        }
    }

    @Test
    void testBrowsePlaylistSongMusicResponsiveListItemRenderer3() {
        final String fileName = "ytm/browse/playlist_continued_song_musicResponsiveListItemRenderer.json";
        try (
                InputStream inStream = LOADER.getResourceAsStream ( fileName ) ;
                InputStreamReader reader = new InputStreamReader ( inStream )
        ) {
            MusicResponsiveListItemRenderer renderer = GranularParser.musicResponsiveListItemRenderer ( reader );

            InnertubeSong song = InnertubeSong.from ( renderer );
            Assertions.assertEquals ( "Qzb2VcBuA3U", song.getId () );
            Assertions.assertEquals ( "Clint Eastwood", song.getName () );
            Assertions.assertFalse ( song.getThumbnails ().isEmpty () );
            Assertions.assertEquals ( "5:41", song.getDurationText () );
            Assertions.assertTrue ( song.isExplicit () );

            Assertions.assertNotNull ( song.getAlbum () );
            Assertions.assertEquals ( "Gorillaz", song.getAlbum ().getText () );
            Assertions.assertNotNull ( song.getAlbum ().getNavigationEndpoint () );
            Assertions.assertEquals (
                    "MPREb_4bUnq6rWRE7",
                    song.getAlbum ().getNavigationEndpoint ().getBrowseEndpoint ().getBrowseId ()
            );

            Assertions.assertFalse ( song.getAuthors ().isEmpty () );
            Assertions.assertNull ( song.getAuthors ().getFirst ().getNavigationEndpoint () );
            Assertions.assertEquals ( "Gorillaz & Del The Funky Homosapien", song.getAuthorsText () );
        } catch ( IOException e ) {
            Assertions.fail ( "Failed to read file %1$s because %2$s".formatted ( fileName, e.getMessage () ) );
        }
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