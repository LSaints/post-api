package br.com.lsant.postApi.domain.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
public class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_issue", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Date dateIssue;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_update")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Date dateUpdate;
}
