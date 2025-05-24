package me.knighthat.impl.response;

import lombok.Data;
import me.knighthat.innertube.response.SimpleText;

@Data
public class SimpleTextImpl implements SimpleText {

    private final String            simpleText;
    private final AccessibilityImpl accessibility;
}
