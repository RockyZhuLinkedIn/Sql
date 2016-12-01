package com.rockyzhu.datamodel;

/**
 * Created by hozhu on 11/29/16.
 */
public class Spider {
  private Integer _spiderId;
  private String _name;
  private SpiderType _type;
  private Boolean _active;
/*
  private long _createdAt;
  private long _lastModified;
  private long _deleted; // soft delete
*/
  public Spider() {}

  public Spider setSpiderId(int spiderId) {
    _spiderId = spiderId;
    return this;
  }

  public Integer getSpiderId() {
    return _spiderId;
  }

  public Boolean hasSpiderId() {
    return _spiderId != null;
  }

  public Spider setName(String name) {
    _name = name;
    return this;
  }

  public String getName() {
    return _name;
  }

  public Boolean hasName() {
    return _name != null;
  }

  public Spider setType(SpiderType type) {
    _type = type;
    return this;
  }

  public SpiderType getType() {
    return _type;
  }

  public Boolean hasType() {
    return _type != null;
  }

  public Spider setActive(boolean active) {
    _active = active;
    return this;
  }

  public Boolean isActive() {
    return _active;
  }

  public boolean hasActive() {
    return _active != null;
  }

  public enum SpiderType {
    ABC,
    XYZ,
    $UNKNOWN
  }
}
