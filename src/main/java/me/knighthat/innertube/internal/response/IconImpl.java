package me.knighthat.innertube.internal.response;

import lombok.Value;
import me.knighthat.innertube.response.Icon;

@Value
class IconImpl implements Icon {

    String iconType;
}
