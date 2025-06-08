package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.Icon;

@Value
public class IconImpl implements Icon {

    String iconType;
}
