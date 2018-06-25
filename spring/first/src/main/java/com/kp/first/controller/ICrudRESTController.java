package com.kp.first.controller;

/**
 * ICrudRESTController.java
 * <p>
 * This interface defines the following CRUD operations:
 * C = POST [ ("/") Object/ObjectList ]
 * R = GET [ ("/{id}") Object, ("/") ObjectList ]
 * U = PUT [ ("/{id}") Object ]
 * D = DELETE [ ("/{id}") Object ]
 */
public interface ICrudRESTController {

    /**
     * POST: Object/ObjectList.
     * Add new Object.
     *
     * @return <String>Status of CREATE operation
     */
    String post();

    /**
     * GET: ObjectList.
     * Get all Objects in the Database.
     *
     * @return <String>ObjectList
     */
    String get();

    /**
     * GET: Object.
     * Get Object with the given ID.
     *
     * @param id ID of the Object to be fetched.
     * @return <String> Object
     */
    String getByID(String id);

    /**
     * PUT: Object.
     * Update all details of Object with the given ID.
     *
     * @param id ID of the Object to update.
     * @return <String>Status of UPDATE operation
     */
    String update(String id);

    /**
     * DELETE: Object.
     * Delete Object with the given ID.
     *
     * @param id ID of the Object to be deleted.
     * @return <String>Status of DELETE operation
     */
    String delete(String id);
}
