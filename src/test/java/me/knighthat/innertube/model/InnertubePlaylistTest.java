package me.knighthat.innertube.model;

import me.knighthat.innertube.Constants;
import me.knighthat.innertube.internal.response.GranularParser;
import me.knighthat.innertube.response.BrowseResponse;
import me.knighthat.innertube.response.MusicTwoRowItemRenderer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class InnertubePlaylistTest {

// START: Static fields/functions
    private static final ClassLoader LOADER = InnertubePlaylistTest.class.getClassLoader();
// END: Static fields/functions

    @Test
    void testAlbumPlaylistMusicTwoRowItemRenderer() {
        final String fileName = "ytm/browse/artist_playlist_musicTwoRowItemRenderer.json";
        try (
                InputStream inStream = LOADER.getResourceAsStream( fileName ) ;
                InputStreamReader reader = new InputStreamReader( inStream )
        ) {
            MusicTwoRowItemRenderer renderer = GranularParser.musicTwoRowItemRenderer( reader );

            InnertubePlaylist playlist = InnertubePlaylist.from( renderer );
            Assertions.assertEquals( "VLRDCLAK5uy_llO_Q2poD5rxl31e6b5DClFPaM53sm8fI", playlist.getId() );
            Assertions.assertEquals( "Presenting Kendrick Lamar", playlist.getName() );
            Assertions.assertFalse( playlist.getThumbnails().isEmpty() );
            Assertions.assertEquals( 2, playlist.getThumbnails().size() );
            Assertions.assertNull( playlist.getDescription() );
            Assertions.assertNull( playlist.getSubtitle() );
            Assertions.assertTrue( playlist.getContinuations().isEmpty() );
            Assertions.assertTrue( playlist.getSongs().isEmpty() );
            Assertions.assertNull( playlist.getSongContinuation() );
            Assertions.assertNull( playlist.getVisitorData() );
        } catch ( IOException e ) {
            Assertions.fail( "failed to instantiate InnertubePlaylist with " + fileName );
        }
    }

    @Test
    void testPlaylistTwoColumnBrowseResultsRenderer1() {
        final String fileName = "ytm/browse/playlist_twoColumnBrowseResultsRenderer1.json";
        try (
                InputStream inStream = LOADER.getResourceAsStream( fileName ) ;
                InputStreamReader reader = new InputStreamReader( inStream )
        ) {
            BrowseResponse.Contents.TwoColumnBrowseResultsRenderer renderer = GranularParser.twoColumnBrowseResultsRenderer( reader );

            InnertubePlaylist playlist = InnertubePlaylist.from( Constants.VISITOR_DATA, renderer );
            Assertions.assertEquals( "VLRDCLAK5uy_nZiG9ehz_MQoWQxY5yElsLHCcG0tv9PRg", playlist.getId() );
            Assertions.assertEquals( "Classic Rock's Greatest Hits", playlist.getName() );
            Assertions.assertEquals(
                    "Essential hits from the classic rock era, featuring long hair, big solos and singers who graduated from frontman school with honors!",
                    playlist.getDescription()
            );

            Assertions.assertNotNull( playlist.getSubtitle() );
            Assertions.assertEquals(
                    "119 songs • 7+ hours",
                    playlist.getSubtitleText()
            );

            Assertions.assertFalse( playlist.getThumbnails().isEmpty() );
            Assertions.assertEquals( 4, playlist.getThumbnails().size() );

            String playlistContinuation = Assertions.assertDoesNotThrow(
                    () -> playlist.getContinuations().getFirst().getNextContinuationData().getContinuation()
            );
            Assertions.assertEquals(
                    "4qmFsgI9Ei1WTFJEQ0xBSzV1eV9uWmlHOWVoel9NUW9XUXhZNXlFbHNMSENjRzB0djlQUmcaDGtnRURDTTBHOEFFQQ%3D%3D",
                    playlistContinuation
            );

            String songContinuation = Assertions.assertDoesNotThrow( playlist::getSongContinuation );
            Assertions.assertEquals(
                    "4qmFsgKNARItVkxSRENMQUs1dXlfblppRzllaHpfTVFvV1F4WTV5RWxzTEhDY0cwdHY5UFJnGi5laFZRVkRwRlozUnZUVVJTUkZORWJGcFhiVTUzVTFHU0FRTUl1Z1R3QVFBJTNEmgIrUkRDTEFLNXV5X25aaUc5ZWh6X01Rb1dReFk1eUVsc0xIQ2NHMHR2OVBSZw%3D%3D",
                    songContinuation
            );

            Assertions.assertFalse( playlist.getSongs().isEmpty() );
            Assertions.assertEquals( 100, playlist.getSongs().size() );

            // visitorData is not being tested because it's a constant inserted from statement above
        } catch ( IOException e ) {
            Assertions.fail( "failed to instantiate InnertubePlaylist with " + fileName );
        }
    }

    @Test
    void testPlaylistTwoColumnBrowseResultsRenderer2() {
        final String fileName = "ytm/browse/playlist_twoColumnBrowseResultsRenderer2.json";
        try (
                InputStream inStream = LOADER.getResourceAsStream( fileName ) ;
                InputStreamReader reader = new InputStreamReader( inStream )
        ) {
            BrowseResponse.Contents.TwoColumnBrowseResultsRenderer renderer = GranularParser.twoColumnBrowseResultsRenderer( reader );

            InnertubePlaylist playlist = InnertubePlaylist.from( Constants.VISITOR_DATA, renderer );
            Assertions.assertEquals( "VLRDCLAK5uy_mPolD_J22gS1SKxufARWcTZd1UrAH_0ZI", playlist.getId() );
            Assertions.assertEquals( "deep chill", playlist.getName() );
            Assertions.assertEquals(
                    "Your eternal home for deep house, chill electronic, ambient",
                    playlist.getDescription()
            );

            Assertions.assertNotNull( playlist.getSubtitle() );
            Assertions.assertEquals(
                    "156 songs • 7+ hours",
                    playlist.getSubtitleText()
            );

            Assertions.assertFalse( playlist.getThumbnails().isEmpty() );
            Assertions.assertEquals( 4, playlist.getThumbnails().size() );

            String playlistContinuation = Assertions.assertDoesNotThrow(
                    () -> playlist.getContinuations().getFirst().getNextContinuationData().getContinuation()
            );
            Assertions.assertEquals(
                    "4qmFsgI9Ei1WTFJEQ0xBSzV1eV9tUG9sRF9KMjJnUzFTS3h1ZkFSV2NUWmQxVXJBSF8wWkkaDGtnRURDTTBHOEFFQQ%3D%3D",
                    playlistContinuation
            );

            String songContinuation = Assertions.assertDoesNotThrow( playlist::getSongContinuation );
            Assertions.assertEquals(
                    "4qmFsgKNARItVkxSRENMQUs1dXlfbVBvbERfSjIyZ1MxU0t4dWZBUldjVFpkMVVyQUhfMFpJGi5laFZRVkRwRlozUk1aREJvYmxsclVuSk5SMnQ0VlZHU0FRTUl1Z1R3QVFBJTNEmgIrUkRDTEFLNXV5X21Qb2xEX0oyMmdTMVNLeHVmQVJXY1RaZDFVckFIXzBaSQ%3D%3D",
                    songContinuation
            );

            Assertions.assertFalse( playlist.getSongs().isEmpty() );
            Assertions.assertEquals( 100, playlist.getSongs().size() );

            // visitorData is not being tested because it's a constant inserted from statement above
        } catch ( IOException e ) {
            Assertions.fail( "failed to instantiate InnertubePlaylist with " + fileName );
        }
    }
}