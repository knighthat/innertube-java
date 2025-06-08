package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.SimpleText;

@Value
class SimpleTextImpl implements SimpleText {

    String            simpleText;
    AccessibilityImpl accessibility;
}
