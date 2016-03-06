package shop.model;

import javax.persistence.*;

/**
 * Created by oleg on 05.03.16.
 */

public enum Availability {
    AVAIL,
    NOT_AVAIL,
    BY_ORDER;

    Availability() {

    }
}
