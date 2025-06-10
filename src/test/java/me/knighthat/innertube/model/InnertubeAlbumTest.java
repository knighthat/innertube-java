package me.knighthat.innertube.model;

import me.knighthat.innertube.internal.response.GranularParser;
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
    void testMusicHomeAlbumMusicTwoRowItemRendererConstructor() {
        final String fileName = "ytm/browse/music_home_album_musicTwoRowItemRenderer.json";
        Executable executable = () -> {
            try (
                    InputStream inStream = LOADER.getResourceAsStream( fileName ) ;
                    InputStreamReader reader = new InputStreamReader( inStream )
            ) {
                MusicTwoRowItemRenderer renderer = GranularParser.musicTwoRowItemRenderer( reader );

                InnertubeAlbum album = new InnertubeAlbum( renderer );
                Assertions.assertEquals( "MPREb_T0ssT2HczFT", album.getId() );
                Assertions.assertEquals( "Short n' Sweet (Deluxe)", album.getName() );
                Assertions.assertFalse( album.getThumbnails()
                                             .isEmpty() );
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
    void testArtistAlbumMusicTwoRowItemRenderer() {
        final String fileName = "ytm/browse/artist_album_musicTwoRowItemRenderer.json";
        Executable executable = () -> {
            try (
                    InputStream inStream = LOADER.getResourceAsStream( fileName ) ;
                    InputStreamReader reader = new InputStreamReader( inStream )
            ) {
                MusicTwoRowItemRenderer renderer = GranularParser.musicTwoRowItemRenderer( reader );

                InnertubeAlbum album = new InnertubeAlbum( renderer );
                Assertions.assertEquals( "MPREb_wCND3crJyDP", album.getId() );
                Assertions.assertEquals( "GNX", album.getName() );
                Assertions.assertFalse( album.getThumbnails()
                                             .isEmpty() );
                Assertions.assertEquals( "2024", album.getYear() );
                Assertions.assertTrue( album.isExplicit() );
            }
        };

        Assertions.assertDoesNotThrow(
                executable,
                "failed to instantiate InnertubeSong with " + fileName
        );
    }
}