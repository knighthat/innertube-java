package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.Microformat;

import java.util.List;

@Value
public class MicroformatImpl implements Microformat {

    RendererImpl microformatDataRenderer;

    @Value
    public static class RendererImpl implements Renderer {

        String               urlCanonical;
        String               title;
        String               description;
        ThumbnailsImpl       thumbnail;
        String               siteName;
        String               appName;
        String               androidPackage;
        String               iosAppStoreId;
        String               iosAppArguments;
        String               ogType;
        String               urlApplinksIos;
        String               urlApplinksAndroid;
        String               urlTwitterIos;
        String               urlTwitterAndroid;
        String               twitterCardType;
        String               twitterSiteHandle;
        String               schemaDotOrgType;
        Boolean              noindex;
        Boolean              unlisted;
        Boolean              paid;
        Boolean              familySafe;
        List<String>         tags;
        List<String>         availableCountries;
        PageOwnerDetailsImpl pageOwnerDetails;
        VideoDetailsImpl     videoDetails;
        List<LinkImpl>       linkAlternates;
        String               viewCount;
        String               publishDate;
        String               category;
        String               uploadDate;

        @Value
        public static class PageOwnerDetailsImpl implements PageOwnerDetails {

            String name;
            String externalChannelId;
            String youtubeProfileUrl;
        }

        @Value
        public static class VideoDetailsImpl implements VideoDetails {

            String externalVideoId;
            String durationSeconds;
            String durationIso8601;
        }

        @Value
        public static class LinkImpl implements Link {

            String hrefUrl;
            String title;
            String alternateType;
        }
    }
}
