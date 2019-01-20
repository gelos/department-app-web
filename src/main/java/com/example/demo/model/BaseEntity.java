package com.example.demo.model;

import java.net.URI;
import lombok.Getter;
import uk.co.blackpepper.bowman.annotation.ResourceId;

@Getter
public abstract class BaseEntity {

  private URI id;

  @ResourceId public URI getId() { return id; }

}
