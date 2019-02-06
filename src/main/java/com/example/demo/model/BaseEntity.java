package com.example.demo.model;

import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import uk.co.blackpepper.bowman.annotation.ResourceId;

@Getter
@Setter // Need for setting id in object while transfer data between html and controller 
public abstract class BaseEntity {

  private URI id;

  @ResourceId public URI getId() { return id; }

}
