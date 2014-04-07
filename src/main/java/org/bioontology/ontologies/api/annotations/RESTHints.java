package org.bioontology.ontologies.api.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @author palexand
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface RESTHints {

    public String mediaType();
//   String date();
//   int currentRevision() default 1;
//   String lastModified() default "N/A";
//   String lastModifiedBy() default "N/A";
//   // Note use of array
//   String[] reviewers();
}
