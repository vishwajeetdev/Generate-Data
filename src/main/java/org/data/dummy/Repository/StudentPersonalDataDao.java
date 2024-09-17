package org.data.dummy.Repository;

import org.data.dummy.Entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;


@Repository
public interface StudentPersonalDataDao extends JpaRepository<PersonalData, String> {

    @Query(value = "SELECT * FROM CLIENT_INFORMATION LIMIT 10", nativeQuery = true)
    List<PersonalData> get10Rows();

    @Query(value = "SELECT COUNT(*) FROM CLIENT_INFORMATION", nativeQuery = true)
    long getCount();
}
