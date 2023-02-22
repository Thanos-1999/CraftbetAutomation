

package Utills.exceptions;

import java.awt.*;
import java.sql.Driver;

public class HeadlessNotSupportedException extends IllegalStateException {

    public HeadlessNotSupportedException() {
        super("Headless not supported for this browser");
    }
}

