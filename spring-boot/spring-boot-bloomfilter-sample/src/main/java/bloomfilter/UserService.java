package bloomfilter;

import java.util.List;

/**
 * 描述: .
 * <p>
 * Copyright © 2022 <a href="https://www.jcohy.com" target= "_blank">https://www.jcohy.com</a>
 * </p>
 *
 * @author jiac
 * @version 2022.04.0 2022/9/1:14:36
 * @since 2022.04.0
 */

public interface UserService {

    List<User> findAllUser();

    User getUserByName(String name);
}
