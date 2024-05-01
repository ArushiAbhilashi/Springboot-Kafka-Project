package org.kafka.consumer.database.repository;

import org.kafka.consumer.database.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaDataRepository extends JpaRepository<WikimediaData,Long> {
	

}
