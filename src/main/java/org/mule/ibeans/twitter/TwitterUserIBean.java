/*
 * $Id: TwitterUserIBean.java 297 2011-04-12 00:12:01Z dzapata $
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.ibeans.twitter;

import org.mule.tools.cloudconnect.annotations.Operation;

import org.ibeans.api.channel.HTTP;

import org.ibeans.annotation.Call;
import org.ibeans.annotation.param.Optional;
import org.ibeans.annotation.param.PropertyParam;
import org.ibeans.annotation.param.UriParam;
import org.ibeans.api.CallException;

/**
 * Methods for looking up Twitter users
 */
public interface TwitterUserIBean extends TwitterBase
{
    /**
     * Returns extended information of a given user, specified by ID or screen name
     * as per the required id parameter. The author's most recent status will be
     * returned inline. Requires Authentication: false API rate limited: true
     * 
     * @param status The text of your status update. URL encode as necessary.
     *            Statuses over 140 characters will be forceably truncated.
     * @param <T> The return type class defined in the
     *            {@link TwitterBase#setFormat(org.mule.ibeans.twitter.TwitterBase.FORMAT, Class)}
     *            or
     *            {@link TwitterBase#setFormat(org.mule.ibeans.twitter.TwitterBase.FORMAT)}
     *            methods or uses the default return type
     *            {@link TwitterBase#DEFAULT_RETURN_TYPE}. The Twitter API supports
     *            XML and JSON, valid values are {@link String},
     *            {@link org.mule.module.json.JsonData}, {@link org.w3c.dom.Document}
     *            .
     * @return The result of the search in the format defined by param <T>
     * @throws CallException if there is an error making the request or the request
     *             returns an error
     */
    @Operation
    @Call(uri = TwitterBase.TWITTER_REST_URL + "/{version}/users/show.{format}?screen_name={screen_name}&include_entities={include_entities}", properties = {HTTP.GET})
    public <T> T getUser(@UriParam("screen_name") String screenName) throws CallException;

    /**
     * Returns extended information of a given user, specified by ID or screen name
     * as per the required id parameter. The author's most recent status will be
     * returned inline. Requires Authentication: false API rate limited: true
     * 
     * @param status The text of your status update. URL encode as necessary.
     *            Statuses over 140 characters will be forceably truncated.
     * @param <T> The return type class defined in the
     *            {@link TwitterBase#setFormat(org.mule.ibeans.twitter.TwitterBase.FORMAT, Class)}
     *            or
     *            {@link TwitterBase#setFormat(org.mule.ibeans.twitter.TwitterBase.FORMAT)}
     *            methods or uses the default return type
     *            {@link TwitterBase#DEFAULT_RETURN_TYPE}. The Twitter API supports
     *            XML and JSON, valid values are {@link String},
     *            {@link org.mule.module.json.JsonData}, {@link org.w3c.dom.Document}
     *            .
     * @param accessToken the oauth user access key.           
     * @param accessSecret the oauth user access secret.           
     * @return The result of the search in the format defined by param <T>
     * @throws CallException if there is an error making the request or the request
     *             returns an error
     */
    @Call(uri = TwitterBase.TWITTER_REST_URL + "/{version}/users/show.{format}?screen_name={screen_name}&include_entities={include_entities}", properties = {HTTP.GET})
    public <T> T getUser(@UriParam("screen_name") String screenName, @Optional @PropertyParam("oauth.access.token") String accessToken,
                         @Optional @PropertyParam("oauth.access.secret") String accessSecret) throws CallException;

}