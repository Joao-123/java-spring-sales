package org.pivotal.services;

import org.pivotal.models.ModelProject;
import org.pivotal.support.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton Helper Class.
 */
public class HelperProjectList {

    private static final String ENTITY = "project";
    private static HelperProjectList helperProjectList;
    private List<ModelProject> modelProjectList;
    private Response<ModelProject> response;

    private HelperProjectList() {
        response = new Response<>();
        modelProjectList = new ArrayList<>();
    }

    /**
     * @return Singleton.
     */
    private static HelperProjectList getSingleton() {
        if (helperProjectList == null) {
            helperProjectList = new HelperProjectList();
        }
        return helperProjectList;
    }

    /**
     * @return modelProjectList.
     */
    public static List<ModelProject> getModelProjectList() {
        return getSingleton().modelProjectList;
    }

    /**
     * @return response.
     */
    public static Response<ModelProject> getResponse() {
        return getSingleton().response;
    }

    /**
     * @return ENTITY.
     */
    public static String getEntity() {
        return ENTITY;
    }

}
