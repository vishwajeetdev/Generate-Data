package org.data.dummy.service;

import org.data.dummy.Entity.*;

import javax.sql.*;
import java.util.*;

public interface Logic {

    String createTable(int id);

    public Map<Long, List<PersonalData>> get10Rows();




}
