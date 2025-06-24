package me.knighthat.innertube.model;

import me.knighthat.innertube.internal.response.GranularParser;
import me.knighthat.innertube.response.BrowseResponse;
import me.knighthat.innertube.response.MusicTwoRowItemRenderer;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.InputStream;
import java.io.InputStreamReader;

class InnertubeArtistTest {

// START: Static fields/functions
    @NotNull
    private static final ClassLoader LOADER = InnertubeArtistTest.class.getClassLoader();
// END: Static fields/functions

    @Test
    void testMusicTwoRowItemRenderer() {
        final String fileName = "ytm/browse/artist_related_artists_musicTwoRowItemRenderer.json";
        Executable executable = () -> {
            try (
                    InputStream inStream = LOADER.getResourceAsStream( fileName ) ;
                    InputStreamReader reader = new InputStreamReader( inStream )
            ) {
                MusicTwoRowItemRenderer renderer = GranularParser.musicTwoRowItemRenderer( reader );

                InnertubeArtist album = InnertubeArtist.from( renderer );
                Assertions.assertEquals( "UCRY5dYsbIN5TylSbd7gVnZg", album.getId() );
                Assertions.assertEquals( "Kanye West", album.getName() );
                Assertions.assertFalse( album.getThumbnails().isEmpty() );
                Assertions.assertNull( album.getShortNumSubscribers() );
                Assertions.assertNull( album.getLongNumSubscribers() );
                Assertions.assertEquals( "144M monthly audience", album.getShortNumMonthlyAudience() );
                Assertions.assertTrue( album.getSections().isEmpty() );
                Assertions.assertNull( album.getDescription() );
            }
        };

        Assertions.assertDoesNotThrow(
                executable,
                "failed to instantiate InnertubeArtist with " + fileName
        );
    }

    @Test
    void testArtistBrowseResponse() {
        final String fileName = "ytm/browse/artist_browseResponse.json";
        Executable executable = () -> {
            try (
                    InputStream inStream = LOADER.getResourceAsStream( fileName ) ;
                    InputStreamReader reader = new InputStreamReader( inStream )
            ) {
                BrowseResponse renderer = GranularParser.browseResponse( reader );

                InnertubeArtist album = InnertubeArtist.from( renderer );
                Assertions.assertEquals( "UC3lBXcrKFnFAFkfVk5WuKcQ", album.getId() );
                Assertions.assertEquals( "Kendrick Lamar", album.getName() );
                Assertions.assertFalse( album.getThumbnails().isEmpty() );

                Assertions.assertNotNull( album.getShortNumSubscribers() );
                Assertions.assertEquals( "19.3M", album.getShortNumSubscribers() );

                Assertions.assertNotNull( album.getLongNumSubscribers() );
                Assertions.assertEquals( "19.3M subscribers", album.getLongNumSubscribers() );

                Assertions.assertEquals( "324M monthly audience", album.getShortNumMonthlyAudience() );

                Assertions.assertFalse( album.getSections().isEmpty() );
                Assertions.assertEquals(
                        6,
                        // Filter out Videos and Lives, which are not supported currently
                        (int) album.getSections()
                                   .stream()
                                   .filter( s -> !s.getContents().isEmpty() )
                                   .count()
                );

                Assertions.assertNotNull( album.getDescription() );
                Assertions.assertFalse( album.getDescription().isEmpty() );
            }
        };

        Assertions.assertDoesNotThrow(
                executable,
                "failed to instantiate InnertubeArtist with " + fileName
        );
    }
}