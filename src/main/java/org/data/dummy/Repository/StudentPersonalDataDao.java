package org.data.dummy.Repository;

import org.data.dummy.Entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;


@Repository
public interface StudentPersonalDataDao extends JpaRepository<PersonalData, String> {
}
