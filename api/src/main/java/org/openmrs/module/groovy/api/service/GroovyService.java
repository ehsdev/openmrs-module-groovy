/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.groovy.api.service;

import java.util.List;

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.groovy.GroovyScript;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * This service exposes module's core functionality. It is a Spring managed bean which is configured in moduleApplicationContext.xml.
 * <p>
 * It can be accessed only via Context:<br>
 * <code>
 * Context.getService(GroovyModuleService.class).someMethod();
 * </code>
 * 
 * @see org.openmrs.api.context.Context
 */
@Transactional
public interface GroovyService extends OpenmrsService {
     
	@Transactional(readOnly=true)
    List<GroovyScript> getAllScripts();

    @Transactional(readOnly=true)
    GroovyScript getScriptById(Integer id);
    @Transactional(readOnly=true)
    GroovyScript getScript(String scriptName);
    @Transactional
    GroovyScript saveGroovyScript(GroovyScript script);

    @Transactional
    void deleteGroovyScript(GroovyScript script);

    /**
     * Delegates to the GroovyUtil.evaluate(String) method.
     * @param script
     * @return
     */
    String[] evaluate(final String script);

	
}