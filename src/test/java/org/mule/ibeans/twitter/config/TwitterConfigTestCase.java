/*
 * $Id: TwitterConfigTestCase.java 297 2011-04-12 00:12:01Z dzapata $
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.ibeans.twitter.config;

import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.transport.PropertyScope;
import org.mule.construct.SimpleFlowConstruct;
import org.mule.module.json.JsonData;
import org.mule.tck.FunctionalTestCase;

import java.io.StringReader;
import java.util.Collections;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class TwitterConfigTestCase extends FunctionalTestCase
{

    // Timeline

    @Test
    public void testPublicTimeline() throws Exception
    {
        // Make sure public timeline works with defaults
        String string = (String) invokeFlow("public-timeline");
        assertNotNull(string);

        // should return 20 entries
        JsonData data = new JsonData((String) invokeFlow("public-timeline-json"));
        assertNotNull(data);
        assertTrue(data.isArray());

        assertNotNull(data.get("[0]/text"));
        assertNotNull(data.get("[12]/user/name"));
    }

    @Test
    public void testUserTimeline() throws Exception
    {
        JsonData data = new JsonData((String) invokeFlow("user-timeline-json"));
        assertNotNull(data);
        assertTrue(data.isArray());

        assertNotNull(data.get("[0]/text"));
        assertNotNull(data.get("[2]/user/name"));
    }

    @Test
    public void testUserTimelineUserCreds() throws Exception
    {
        JsonData data = new JsonData((String) invokeFlow("user-timeline-json-with-user-creds"));
        assertNotNull(data);
        assertTrue(data.isArray());

        assertNotNull(data.get("[0]/text"));
        assertNotNull(data.get("[2]/user/name"));
    }    
    
    @Test
    public void testFriendsTimeline() throws Exception
    {
        JsonData data = new JsonData((String) invokeFlow("friends-timeline-json"));
        assertNotNull(data);
        assertTrue(data.isArray());

        assertNotNull(data.get("[0]/text"));
        assertNotNull(data.get("[0]/source"));
        //assertNotNull(data.get("[1]/user/name"));
    }

    @Test
    public void testFriendsTimelineUserCreds() throws Exception
    {
        JsonData data = new JsonData((String) invokeFlow("friends-timeline-json-with-user-creds"));
        assertNotNull(data);
        assertTrue(data.isArray());

        assertNotNull(data.get("[0]/text"));
        assertNotNull(data.get("[0]/source"));
        //assertNotNull(data.get("[1]/user/name"));
    }    
    
    @Test
    public void testMentions() throws Exception
    {
        JsonData data = new JsonData((String) invokeFlow("mentions-json"));
        assertNotNull(data);
        assertTrue(data.isArray());

        // assertNotNull(data.get("[0]/text"));
        // assertNotNull(data.get("[2]/user/name"));
    }

    @Test
    public void testMentionsUserCreds() throws Exception
    {
        JsonData data = new JsonData((String) invokeFlow("mentions-json-with-user-creds"));
        assertNotNull(data);
        assertTrue(data.isArray());

        // assertNotNull(data.get("[0]/text"));
        // assertNotNull(data.get("[2]/user/name"));
    }    
    
    // Search

    @Test
    public void testSearch() throws Exception
    {
        String xml = (String) invokeFlow("search-atom");
        assertNotNull(xml);

        Document document = new SAXReader().read(new StringReader(xml));

        assertNotNull(document.selectSingleNode("feed"));
        assertNotNull(document.selectNodes("feed/entry[0]"));
    }

    @Test
    public void testSearchUserCreds() throws Exception
    {
        String xml = (String) invokeFlow("search-atom-with-user-creds");
        assertNotNull(xml);

        Document document = new SAXReader().read(new StringReader(xml));

        assertNotNull(document.selectSingleNode("feed"));
        assertNotNull(document.selectNodes("feed/entry[0]"));
    }    
    
    // Status

    @Test
    public void testStatus() throws Exception
    {
        String statusString = "test : " + System.currentTimeMillis();

        JsonData data = new JsonData((String) invokeFlow("update-status-json", Collections.singletonMap(
            "status", statusString)));          assertNotNull(data);
        assertEquals(statusString, data.getAsString("text"));

        String id = data.getAsString("id");
        System.out.println(id);

        JsonData data2 = new JsonData((String) invokeFlow("show-status-json", Collections.singletonMap(
            "statusId", id)));
        assertNotNull(data2);
        assertEquals(statusString, data2.getAsString("text"));
        System.out.println(data2);

        // JsonData data3 = new JsonData((String) invokeFlow("destroy-status-json",
        // Collections.singletonMap(
        // "statusId", "22025689267965953")));

    }

    @Test
    public void testStatusUserCreds() throws Exception
    {
        // you will get an error if you re-post the same exact status, so append System.currTime... to it
        String statusString = "test : " + System.currentTimeMillis();

        JsonData data = new JsonData((String) invokeFlow("update-status-json-with-user-creds", Collections.singletonMap(
            "status", statusString)));            
            
        assertNotNull(data);
        assertEquals(statusString, data.getAsString("text"));

        String id = data.getAsString("id");
        System.out.println(id);

        JsonData data2 = new JsonData((String) invokeFlow("show-status-json", Collections.singletonMap(
            "statusId", id)));
        assertNotNull(data2);
        assertTrue(data2.getAsString("text").startsWith("test"));
        System.out.println(data2);

        // JsonData data3 = new JsonData((String) invokeFlow("destroy-status-json",
        // Collections.singletonMap(
        // "statusId", "22025689267965953")));

    }    
    
    // User

    @Test
    public void testLookupUser() throws Exception
    {
        JsonData data = new JsonData((String) invokeFlow("lookup-user-json"));
        assertNotNull(data);
        assertEquals("15358364", data.getAsString("id_str"));
        assertEquals("San Francisco", data.getAsString("location"));
    }

    @Test
    public void testLookupUserUserCreds() throws Exception
    {
        JsonData data = new JsonData((String) invokeFlow("lookup-user-json-with-user-creds"));
        assertNotNull(data);
        assertEquals("15358364", data.getAsString("id_str"));
        assertEquals("San Francisco", data.getAsString("location"));
    }    
    
    @Override
    protected String getConfigResources()
    {
        return "twitter-config-test.xml";
    }

    protected Object invokeFlow(String flow) throws MuleException, Exception
    {
        return ((SimpleFlowConstruct) muleContext.getRegistry().lookupFlowConstruct(flow)).process(
            getTestEvent("")).getMessage().getPayload();
    }

    protected Object invokeFlow(String flow, Map properties) throws MuleException, Exception
    {
        MuleEvent event = getTestEvent("");
        event.getMessage().addProperties(properties, PropertyScope.INVOCATION);
        return ((SimpleFlowConstruct) muleContext.getRegistry().lookupFlowConstruct(flow)).process(event)
            .getMessage()
            .getPayload();
    }
}