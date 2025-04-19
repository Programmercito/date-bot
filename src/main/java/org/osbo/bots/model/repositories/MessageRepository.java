package org.osbo.bots.model.repositories;

import org.osbo.bots.model.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, String> {
    // Métodos personalizados si es necesario
}