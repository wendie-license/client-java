package top.todu.wendie.client;

import java.io.Serializable;
import java.util.Date;

/**
 * License info <br>
 *
 * @author sdvdxl <杜龙少> <br>
 * @date 2020/4/13 13:05 <br>
 */
public class License implements Serializable {
  private static final long serialVersionUID = -2353626706041116039L;
  /** not before if not null */
  private Date before;

  /** not after if not null */
  private Date after;

  /**
   * if valid
   *
   * @return true： valid； false invalid
   */
  public boolean isValid() {
    return false;
  }
}
