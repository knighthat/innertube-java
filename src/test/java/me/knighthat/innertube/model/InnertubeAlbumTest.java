package me.knighthat.innertube.model;

import me.knighthat.innertube.internal.response.GranularParser;
import me.knighthat.innertube.response.MusicResponsiveListItemRenderer;
import me.knighthat.innertube.response.MusicTwoRowItemRenderer;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.InputStream;
import java.io.InputStreamReader;

class InnertubeAlbumTest {

    // START: Static fields/functions
    @NotNull
    private static final ClassLoader LOADER = InnertubeSongTest.class.getClassLoader();
    // END: Static fields/functions

    @Test
    void testBrowseMusicHomeAlbumMusicTwoRowItemRendererConstructor() {
        final String fileName = "ytm/browse/music_home_album_musicTwoRowItemRenderer.json";
        Executable executable = () -> {
            try (
                    InputStream inStream = LOADER.getResourceAsStream( fileName ) ;
                    InputStreamReader reader = new InputStreamReader( inStream )
            ) {
                MusicTwoRowItemRenderer renderer = GranularParser.musicTwoRowItemRenderer( reader );

                InnertubeAlbum album = InnertubeAlbum.from( renderer );
                Assertions.assertEquals( "MPREb_T0ssT2HczFT", album.getId() );
                Assertions.assertEquals( "Short n' Sweet (Deluxe)", album.getName() );
                Assertions.assertFalse( album.getThumbnails().isEmpty() );
                Assertions.assertEquals( "", album.getYear() );
                Assertions.assertTrue( album.isExplicit() );
            }
        };

        Assertions.assertDoesNotThrow(
                executable,
                "failed to instantiate InnertubeSong with " + fileName
        );
    }

    @Test
    void testBrowseArtistAlbumMusicTwoRowItemRenderer() {
        final String fileName = "ytm/browse/artist_album_musicTwoRowItemRenderer.json";
        Executable executable = () -> {
            try (
                    InputStream inStream = LOADER.getResourceAsStream( fileName ) ;
                    InputStreamReader reader = new InputStreamReader( inStream )
            ) {
                MusicTwoRowItemRenderer renderer = GranularParser.musicTwoRowItemRenderer( reader );

                InnertubeAlbum album = InnertubeAlbum.from( renderer );
                Assertions.assertEquals( "MPREb_wCND3crJyDP", album.getId() );
                Assertions.assertEquals( "GNX", album.getName() );
                Assertions.assertFalse( album.getThumbnails().isEmpty() );
                Assertions.assertTrue( album.getArtists().isEmpty() );
                Assertions.assertEquals( "2024", album.getYear() );
                Assertions.assertTrue( album.isExplicit() );
            }
        };

        Assertions.assertDoesNotThrow(
                executable,
                "failed to instantiate InnertubeSong with " + fileName
        );
    }

    @Test
    void testBrowseAlbumAlternativeMusicTwoRowItemRenderer() {
        final String fileName = "ytm/browse/album_alternative_musicTwoRowItemRenderer.json";
        Executable executable = () -> {
            try (
                    InputStream inStream = LOADER.getResourceAsStream( fileName ) ;
                    InputStreamReader reader = new InputStreamReader( inStream )
            ) {
                MusicTwoRowItemRenderer renderer = GranularParser.musicTwoRowItemRenderer( reader );

                InnertubeAlbum album = InnertubeAlbum.from( renderer );
                Assertions.assertEquals( "MPREb_m10OjDmOhfv", album.getId() );
                Assertions.assertEquals( "Hybrid Theory (Bonus Edition)", album.getName() );
                Assertions.assertFalse( album.getThumbnails().isEmpty() );
                Assertions.assertFalse( album.getArtists().isEmpty() );
                Assertions.assertEquals( "", album.getYear() );
                Assertions.assertFalse( album.isExplicit() );
            }
        };

        Assertions.assertDoesNotThrow(
                executable,
                "failed to instantiate InnertubeSong with " + fileName
        );
    }

    @Test
    void testSearchAlbumMusicResponsiveListItemRenderer() {
        final String fileName = "ytm/search/album_musicResponsiveListItemRenderer.json";
        Executable executable = () -> {
            try (
                    InputStream inStream = LOADER.getResourceAsStream( fileName ) ;
                    InputStreamReader reader = new InputStreamReader( inStream )
            ) {
                MusicResponsiveListItemRenderer renderer = GranularParser.musicResponsiveListItemRenderer( reader );

                InnertubeAlbum album = InnertubeAlbum.from( renderer );
                Assertions.assertEquals( "MPREb_LiSIhY0SLZZ", album.getId() );
                Assertions.assertEquals( "A Bar Song", album.getName() );
                Assertions.assertFalse( album.getThumbnails().isEmpty() );
                Assertions.assertFalse( album.getArtists().isEmpty() );
                Assertions.assertEquals( "2025", album.getYear() );
                Assertions.assertFalse( album.isExplicit() );
            }
        };

        Assertions.assertDoesNotThrow(
                executable,
                "failed to instantiate InnertubeSong with " + fileName
        );
    }
}