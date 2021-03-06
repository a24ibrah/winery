/*******************************************************************************
 * Copyright (c) 2017 University of Stuttgart.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and the Apache License 2.0 which both accompany this distribution,
 * and are available at http://www.eclipse.org/legal/epl-v10.html
 * and http://www.apache.org/licenses/LICENSE-2.0
 *
 * Contributors:
 *     Karoline Saatkamp - initial API and implementation
 *******************************************************************************/

package org.eclipse.winery.repository.resources._support.dataadapter;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.eclipse.winery.model.tosca.TNodeTemplate;

public class InjectionDataMapAdapter extends XmlAdapter<Injections, Map<String, TNodeTemplate>> {

	@Override
	public Map<String, TNodeTemplate> unmarshal(Injections injections) throws Exception {
		Map<String, TNodeTemplate> mapInjections = new HashMap<>();
		for (Injection injection : injections.getInjections()) {
			mapInjections.put(injection.hostedNodeID, injection.hostNodeTemplate);
		}
		return mapInjections;
	}

	@Override
	public Injections marshal(Map<String, TNodeTemplate> mapInjections) throws Exception {
		Injections injections = new Injections();
		for (Map.Entry<String, TNodeTemplate> entry : mapInjections.entrySet()) {
			injections.addInjection(new Injection(entry.getKey(), entry.getValue()));
		}
		return injections;
	}
}
