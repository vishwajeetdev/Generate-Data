package org.data.dummy.service;


import jakarta.persistence.*;
import jakarta.transaction.*;
import lombok.*;
import lombok.extern.log4j.*;
import org.data.dummy.Entity.*;
import org.data.dummy.Repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.concurrent.*;

@Service
@Log4j2
@NoArgsConstructor
@AllArgsConstructor
public class LogicImpl implements Logic {


    @PersistenceContext
    private EntityManager entityManager;


    private Microservices microservices;

    private StudentPersonalDataDao studentPersonalDataDao;


    private int rowInserted = 0;
    private boolean flag = true;


    @Autowired
    public void setMicroservices(Microservices microservice, StudentPersonalDataDao studentPersonalDataDao) {

        this.microservices = microservice;

        this.studentPersonalDataDao = studentPersonalDataDao;

    }

    private static String formatElapsedTime(long elapsedTimeMillis) {
        long hours = TimeUnit.MILLISECONDS.toHours(elapsedTimeMillis);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(elapsedTimeMillis) % TimeUnit.HOURS.toMinutes(1);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(elapsedTimeMillis) % TimeUnit.MINUTES.toSeconds(1);
        long milliseconds = elapsedTimeMillis % 1000;

        return String.format("%02d:%02d:%02d:%03d", hours, minutes, seconds, milliseconds);
    }


    @Transactional
    public String createTable(int id) {
        long startTime = System.currentTimeMillis();

        while (id > 0) {

            int num = 100;
            savePersonalised(num);
            id = id - num;


            long endTime = System.currentTimeMillis();
            log.info("System Running for : {} & Row Processed {} ", formatElapsedTime(endTime - startTime), rowInserted);
        }

        long endTime = System.currentTimeMillis();
        long totalDuration = endTime - startTime;
        String formattedTotalDuration = formatElapsedTime(totalDuration);
        log.info("Total time taken for execution: {} & Row Processed {}", formattedTotalDuration, rowInserted);

        return formattedTotalDuration;
    }


    @Transactional
    void savePersonalised(int num) {

        List<PersonalData> data = new ArrayList<>();

        if (flag) {
            data = microservices.generateMultipleMaleData(num);

            //studentPersonalDataDao.saveAll(microservices.generateMultipleMaleData(num));
            flag = false;
        } else {
            data = microservices.generateMultipleFemaleData(num);
            //studentPersonalDataDao.saveAll(microservices.generateMultipleFemaleData(num));
            flag = true;

        }
        for (int i = 0; i < data.size(); i++) {
            entityManager.persist(data.get(i));

            if (i % 10 == 0 && i > 0) {
                entityManager.flush();
                entityManager.clear();
            }
        }

        entityManager.flush();
        entityManager.clear();

        rowInserted += num;


    }


    public Map<Long, List<PersonalData>> get10Rows() {


        Map<Long, List<PersonalData>> data = new HashMap<>();

        data.put(studentPersonalDataDao.getCount(), studentPersonalDataDao.get10Rows());
        return data;


    }


}
