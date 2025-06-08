package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.Microformat;

import java.util.List;

@Value
class MicroformatImpl implements Microformat {

    RendererImpl microformatDataRenderer;

    @Value
    static class RendererImpl implements Renderer {

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
        static class PageOwnerDetailsImpl implements PageOwnerDetails {

            String name;
            String externalChannelId;
            String youtubeProfileUrl;
        }

        @Value
        static class VideoDetailsImpl implements VideoDetails {

            String externalVideoId;
            String durationSeconds;
            String durationIso8601;
        }

        @Value
        static class LinkImpl implements Link {

            String hrefUrl;
            String title;
            String alternateType;
        }
    }
}
