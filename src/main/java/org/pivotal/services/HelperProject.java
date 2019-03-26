package org.pivotal.services;

import org.pivotal.models.ModelProject;

/**
 * Helper Project Class.
 */
public class HelperProject {

    private String id;
    private ModelProject modelProject;
    private static HelperProject helperProject;

    /**
     * @return Singleton.
     */
    private static HelperProject getSingleton() {
        if (helperProject == null) {
            helperProject = new HelperProject();
        }
        return helperProject;
    }

    /**
     * @return id.
     */
    public static String getId() {
        return getSingleton().id;
    }

    /**
     * @param id id.
     */
    public static void setId(String id) {
        getSingleton().id = id;
    }

    /**
     * @return ModelProject.
     */
    public static ModelProject getModelProject() {
        return getSingleton().modelProject;
    }

    /**
     * @param modelProject modelProject.
     */
    public static void setModelProject(ModelProject modelProject) {
        getSingleton().modelProject = modelProject;
    }
}
