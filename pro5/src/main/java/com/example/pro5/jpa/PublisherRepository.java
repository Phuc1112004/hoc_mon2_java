package com.example.pro5.jpa;

import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;

public interface PublisherRepository extends JpaAttributeConverter<Publisher,Long> {
}
