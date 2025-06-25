package me.knighthat.innertube.model;

import me.knighthat.innertube.Constants;
import me.knighthat.innertube.internal.response.GranularParser;
import me.knighthat.innertube.response.BrowseResponse;
import me.knighthat.innertube.response.MusicTwoRowItemRenderer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.InputStream;
import java.io.InputStreamReader;

class InnertubePlaylistTest {

// START: Static fields/functions
    private static final ClassLoader LOADER = InnertubePlaylistTest.class.getClassLoader();
// END: Static fields/functions

    @Test
    void testAlbumPlaylistMusicTwoRowItemRenderer() {
        final String fileName = "ytm/browse/artist_playlist_musicTwoRowItemRenderer.json";
        Executable executable = () -> {
            try (
                    InputStream inStream = LOADER.getResourceAsStream( fileName ) ;
                    InputStreamReader reader = new InputStreamReader( inStream )
            ) {
                MusicTwoRowItemRenderer renderer = GranularParser.musicTwoRowItemRenderer( reader );

                InnertubePlaylist playlist = InnertubePlaylist.from( renderer );
                Assertions.assertEquals( "VLRDCLAK5uy_llO_Q2poD5rxl31e6b5DClFPaM53sm8fI", playlist.getId() );
                Assertions.assertEquals( "Presenting Kendrick Lamar", playlist.getName() );
                Assertions.assertFalse( playlist.getThumbnails().isEmpty() );
                Assertions.assertNull( playlist.getDescription() );
                Assertions.assertTrue( playlist.getContinuations().isEmpty() );
                Assertions.assertTrue( playlist.getSongs().isEmpty() );
                Assertions.assertNull( playlist.getSongContinuation() );
            }
        };

        Assertions.assertDoesNotThrow(
                executable,
                "failed to instantiate InnertubePlaylist with " + fileName
        );
    }

    @Test
    void testPlaylistTwoColumnBrowseResultsRenderer() {
        final String fileName = "ytm/browse/playlist_twoColumnBrowseResultsRenderer.json";
        Executable executable = () -> {
            try (
                    InputStream inStream = LOADER.getResourceAsStream( fileName ) ;
                    InputStreamReader reader = new InputStreamReader( inStream )
            ) {
                BrowseResponse.Contents.TwoColumnBrowseResultsRenderer renderer = GranularParser.twoColumnBrowseResultsRenderer( reader );

                InnertubePlaylist playlist = InnertubePlaylist.from( Constants.VISITOR_DATA, renderer );
                Assertions.assertEquals( "VLRDCLAK5uy_nZiG9ehz_MQoWQxY5yElsLHCcG0tv9PRg", playlist.getId() );
                Assertions.assertEquals( "Classic Rock's Greatest Hits", playlist.getName() );
                Assertions.assertFalse( playlist.getThumbnails().isEmpty() );
                Assertions.assertEquals(
                        "Essential hits from the classic rock era, featuring long hair, big solos and singers who graduated from frontman school with honors!",
                        playlist.getDescription()
                );
                Assertions.assertEquals(
                        "4qmFsgI9Ei1WTFJEQ0xBSzV1eV9uWmlHOWVoel9NUW9XUXhZNXlFbHNMSENjRzB0djlQUmcaDGtnRURDTTBHOEFFQQ%3D%3D",
                        playlist.getContinuations().getFirst().getNextContinuationData().getContinuation()
                );
                Assertions.assertEquals( 100, playlist.getSongs().size() );
                Assertions.assertEquals(
                        "4qmFsgKNARItVkxSRENMQUs1dXlfblppRzllaHpfTVFvV1F4WTV5RWxzTEhDY0cwdHY5UFJnGi5laFZRVkRwRlozUnZUVVJTUkZORWJGcFhiVTUzVTFHU0FRTUl1Z1R3QVFBJTNEmgIrUkRDTEFLNXV5X25aaUc5ZWh6X01Rb1dReFk1eUVsc0xIQ2NHMHR2OVBSZw%3D%3D",
                        playlist.getSongContinuation()
                );
            }
        };

        Assertions.assertDoesNotThrow(
                executable,
                "failed to instantiate InnertubePlaylist with " + fileName
        );
    }
}