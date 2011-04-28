/*
 * $Id: TwitterSearchIBean.java 297 2011-04-12 00:12:01Z dzapata $
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSource, Inc.  All rights reserved.  http://www.mulesource.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.ibeans.twitter;

import org.mule.tools.cloudconnect.annotations.Operation;

import org.ibeans.annotation.Call;
import org.ibeans.annotation.param.Optional;
import org.ibeans.annotation.param.PropertyParam;
import org.ibeans.annotation.param.UriParam;
import org.ibeans.api.CallException;
import org.ibeans.api.channel.HTTP;

/**
 * Search methods for querying Twitter and trends
 */
public interface TwitterSearchIBean
{
    /**
     * Returns tweets that match a specified query.
     * <p/>
     * Usage Notes:
     * Query strings should be URL encoded.
     * Queries are limited 140 URL encoded characters.
     * Some users may be absent from search results.
     * The since_id parameter will be removed from the next_page element as it is not supported for pagination. If since_id is removed a warning will be added to alert you.
     * This method will return an HTTP 404 error if since_id is used and is too old to be in the search index.
     * If you are having trouble constructing your query, use the advanced search form to construct your search, then add the format. For example http://search.twitter.com/search?q=twitter would become http://search.twitter.com/search.json?q=twitter
     * Applications must have a meaningful and unique User Agent when using this method. A HTTP Referrer is expected but not required. Search traffic that does not include a User Agent will be rate limited to fewer API calls per hour than applications including a User Agent string.
     * <p/>
     * Formats: json, atom
     * Requires Authentication: false
     * API rate limited: 1 call per request
     *
     * @param query the query string to search twitter.  See the search guide for details of what can be done: http://apiwiki.twitter.com/Twitter-Search-API-Method%3A-search
     * @param <T>   The return type class defined in the {@link TwitterBase#setFormat(org.mule.ibeans.twitter.TwitterBase.FORMAT, Class)} or
     *              {@link TwitterBase#setFormat(org.mule.ibeans.twitter.TwitterBase.FORMAT)} methods or uses the default return type
     *              {@link TwitterBase#DEFAULT_RETURN_TYPE}. The Twitter Search API supports ATOM and JSON, valid values are {@link String},
     *              {@link org.mule.module.json.JsonData}, {@link org.w3c.dom.Document}, {@link org.apache.abdera.model.Feed}.
     * @return The result of the search in the format defined by param <T>, if authentication fails if the credentials do not validate.
     * @throws CallException if there is an error making the request or the request returns an error
     */
    @Operation
    @Call(uri = TwitterBase.TWITTER_SEARCH_URL + "/search.{format}?q={query}", properties = {HTTP.GET})
    public <T> T search(@UriParam("query") String query) throws CallException;

    /**
     * Returns tweets that match a specified query.
     * <p/>
     * Usage Notes:
     * Query strings should be URL encoded.
     * Queries are limited 140 URL encoded characters.
     * Some users may be absent from search results.
     * The since_id parameter will be removed from the next_page element as it is not supported for pagination. If since_id is removed a warning will be added to alert you.
     * This method will return an HTTP 404 error if since_id is used and is too old to be in the search index.
     * If you are having trouble constructing your query, use the advanced search form to construct your search, then add the format. For example http://search.twitter.com/search?q=twitter would become http://search.twitter.com/search.json?q=twitter
     * Applications must have a meaningful and unique User Agent when using this method. A HTTP Referrer is expected but not required. Search traffic that does not include a User Agent will be rate limited to fewer API calls per hour than applications including a User Agent string.
     * <p/>
     * Formats: json, atom
     * Requires Authentication: false
     * API rate limited: 1 call per request
     *
     * @param query    the query string to search twitter.  See the search guide for details of what can be done: http://apiwiki.twitter.com/Twitter-Search-API-Method%3A-search
     * @param lang     Restricts tweets to the given language, given by an ISO 639-1 code: http://en.wikipedia.org/wiki/ISO_639-1. Optional.
     * @param locale   Specify the language of the query you are sending (only ja is currently effective). This is intended
     *                 for language-specific clients and the default should work in the majority of cases. Optional.
     * @param rpp      The number of tweets to return per page, up to a max of 100. Optional.
     * @param page     The page number (starting at 1) to return, up to a max of roughly 1500 results (based on rpp * page). Optional.
     * @param sinceId  Returns tweets with status ids greater than the given id. Optional.
     * @param geocode  Returns tweets by users located within a given radius of the given latitude/longitude, where the
     *                 user's location is taken from their Twitter profile. The parameter value is specified by "latitide,longitude,radius",
     *                 where radius units must be specified as either "mi" (miles) or "km" (kilometers). Note that you cannot use the near
     *                 operator via the API to geocode arbitrary locations; however you can use this geocode parameter to search near
     *                 geocodes directly. Optional.
     * @param showUser When true, prepends "<user>:" to the beginning of the tweet. This is useful for readers that do
     *                 not display Atom's author field. The default is false. Optional.
     * @param <T>      The return type class defined in the {@link TwitterBase#setFormat(org.mule.ibeans.twitter.TwitterBase.FORMAT, Class)} or
     *                 {@link TwitterBase#setFormat(org.mule.ibeans.twitter.TwitterBase.FORMAT)} methods or uses the default return type
     *                 {@link TwitterBase#DEFAULT_RETURN_TYPE}. The Twitter Search API supports ATOM and JSON, valid values are {@link String},
     *                 {@link org.mule.module.json.JsonData}, {@link org.w3c.dom.Document}, {@link org.apache.abdera.model.Feed}.
     * @return The result of the search in the format defined by param <T>, if authentication fails if the credentials do not validate.
     * @throws CallException if there is an error making the request or the request returns an error
     */
    @Operation
    @Call(uri = TwitterBase.TWITTER_SEARCH_URL + "/search.{format}?q={query}&lang={lang}&locale={locale}&rpp={rpp}&page={page}&since_id={since_id}&geocode={geocode}&show_user={show_user}")
    public <T> T search(@UriParam("query") String query, @Optional @UriParam("lang") String lang, @Optional @UriParam("locale") String locale, @Optional @UriParam("rpp") String rpp, @Optional @UriParam("page") String page, @Optional @UriParam("since_id") String sinceId, @Optional @UriParam("geocode") String geocode, @Optional @UriParam("show_user") String showUser ) throws CallException;

    /**
     * Returns tweets that match a specified query.
     * <p/>
     * Usage Notes:
     * Query strings should be URL encoded.
     * Queries are limited 140 URL encoded characters.
     * Some users may be absent from search results.
     * The since_id parameter will be removed from the next_page element as it is not supported for pagination. If since_id is removed a warning will be added to alert you.
     * This method will return an HTTP 404 error if since_id is used and is too old to be in the search index.
     * If you are having trouble constructing your query, use the advanced search form to construct your search, then add the format. For example http://search.twitter.com/search?q=twitter would become http://search.twitter.com/search.json?q=twitter
     * Applications must have a meaningful and unique User Agent when using this method. A HTTP Referrer is expected but not required. Search traffic that does not include a User Agent will be rate limited to fewer API calls per hour than applications including a User Agent string.
     * <p/>
     * Formats: json, atom
     * Requires Authentication: false
     * API rate limited: 1 call per request
     *
     * @param query    the query string to search twitter.  See the search guide for details of what can be done: http://apiwiki.twitter.com/Twitter-Search-API-Method%3A-search
     * @param lang     Restricts tweets to the given language, given by an ISO 639-1 code: http://en.wikipedia.org/wiki/ISO_639-1. Optional.
     * @param locale   Specify the language of the query you are sending (only ja is currently effective). This is intended
     *                 for language-specific clients and the default should work in the majority of cases. Optional.
     * @param rpp      The number of tweets to return per page, up to a max of 100. Optional.
     * @param page     The page number (starting at 1) to return, up to a max of roughly 1500 results (based on rpp * page). Optional.
     * @param sinceId  Returns tweets with status ids greater than the given id. Optional.
     * @param geocode  Returns tweets by users located within a given radius of the given latitude/longitude, where the
     *                 user's location is taken from their Twitter profile. The parameter value is specified by "latitide,longitude,radius",
     *                 where radius units must be specified as either "mi" (miles) or "km" (kilometers). Note that you cannot use the near
     *                 operator via the API to geocode arbitrary locations; however you can use this geocode parameter to search near
     *                 geocodes directly. Optional.
     * @param showUser When true, prepends "<user>:" to the beginning of the tweet. This is useful for readers that do
     *                 not display Atom's author field. The default is false. Optional.
     * @param <T>      The return type class defined in the {@link TwitterBase#setFormat(org.mule.ibeans.twitter.TwitterBase.FORMAT, Class)} or
     *                 {@link TwitterBase#setFormat(org.mule.ibeans.twitter.TwitterBase.FORMAT)} methods or uses the default return type
     *                 {@link TwitterBase#DEFAULT_RETURN_TYPE}. The Twitter Search API supports ATOM and JSON, valid values are {@link String},
     *                 {@link org.mule.module.json.JsonData}, {@link org.w3c.dom.Document}, {@link org.apache.abdera.model.Feed}.
     * @param accessToken the oauth user access key.           
     * @param accessSecret the oauth user access secret.  
     *            
     * @return The result of the search in the format defined by param <T>, if authentication fails if the credentials do not validate.
     * @throws CallException if there is an error making the request or the request returns an error
     */
    @Operation
    @Call(uri = TwitterBase.TWITTER_SEARCH_URL + "/search.{format}?q={query}&lang={lang}&locale={locale}&rpp={rpp}&page={page}&since_id={since_id}&geocode={geocode}&show_user={show_user}")
    public <T> T search(@UriParam("query") String query, @Optional @UriParam("lang") String lang, @Optional @UriParam("locale") String locale, @Optional @UriParam("rpp") String rpp, @Optional @UriParam("page") String page, @Optional @UriParam("since_id") String sinceId, @Optional @UriParam("geocode") String geocode, @Optional @UriParam("show_user") String showUser, @Optional @PropertyParam("oauth.access.token") String accessToken,
                        @Optional @PropertyParam("oauth.access.secret") String accessSecret) throws CallException;

    /**
     * Returns tweets that match a specified query.
     * Formats: json, atom
     * Requires Authentication: false
     * API rate limited: 1 call per request
     *
     * @param query    the query string to search twitter.  See the search guide for details of what can be done: http://apiwiki.twitter.com/Twitter-Search-API-Method%3A-search
     * @param callback the name of the JavaScript callback to notify when the search results are ready. (Uses JSONP)
     * @param <T>      The return type class defined in the {@link TwitterBase#setFormat(org.mule.ibeans.twitter.TwitterBase.FORMAT, Class)} or
     *                 {@link TwitterBase#setFormat(org.mule.ibeans.twitter.TwitterBase.FORMAT)} methods or uses the default return type
     *                 {@link TwitterBase#DEFAULT_RETURN_TYPE}. The Twitter Search API supports ATOM and JSON, valid values are {@link String},
     *                 {@link org.mule.module.json.JsonData}, {@link org.w3c.dom.Document}, {@link org.apache.abdera.model.Feed}.
     * @return The result of the search in the format defined by param <T>, if authentication fails if the credentials do not validate.
     * @throws CallException if there is an error making the request or the request returns an error
     */
    @Operation
    @Call(uri = TwitterBase.TWITTER_SEARCH_URL + "/search.json?q={query}&callback={callback}")
    public <T> T searchWithJsonCallback(@UriParam("query") String query, @UriParam("callback") String callback) throws CallException;

    /**
     * Returns tweets that match a specified query.
     * Formats: json, atom
     * Requires Authentication: false
     * API rate limited: 1 call per request
     *
     * @param query    the query string to search twitter.  See the search guide for details of what can be done:
     *                 http://apiwiki.twitter.com/Twitter-Search-API-Method%3A-search
     * @param callback the name of the JavaScript callback to notify when the search results are ready. (Uses JSONP)
     * @param lang     Restricts tweets to the given language, given by an ISO 639-1 code: http://en.wikipedia.org/wiki/ISO_639-1. Optional.
     * @param locale   Specify the language of the query you are sending (only ja is currently effective). This is intended
     *                 for language-specific clients and the default should work in the majority of cases. Optional.
     * @param rpp      The number of tweets to return per page, up to a max of 100. Optional.
     * @param page     The page number (starting at 1) to return, up to a max of roughly 1500 results (based on rpp * page). Optional.
     * @param sinceId  Returns tweets with status ids greater than the given id. Optional.
     * @param geocode  Returns tweets by users located within a given radius of the given latitude/longitude, where the
     *                 user's location is taken from their Twitter profile. The parameter value is specified by "latitide,longitude,radius",
     *                 where radius units must be specified as either "mi" (miles) or "km" (kilometers). Note that you cannot use the near
     *                 operator via the API to geocode arbitrary locations; however you can use this geocode parameter to search near
     *                 geocodes directly. Optional.
     * @param showUser When true, prepends "<user>:" to the beginning of the tweet. This is useful for readers that do
     *                 not display Atom's author field. The default is false. Optional.
     * @param <T>      The return type class defined in the {@link TwitterBase#setFormat(org.mule.ibeans.twitter.TwitterBase.FORMAT, Class)} or
     *                 {@link TwitterBase#setFormat(org.mule.ibeans.twitter.TwitterBase.FORMAT)} methods or uses the default return type
     *                 {@link TwitterBase#DEFAULT_RETURN_TYPE}. The Twitter Search API supports ATOM and JSON, valid values are {@link String},
     *                 {@link org.mule.module.json.JsonData}, {@link org.w3c.dom.Document}, {@link org.apache.abdera.model.Feed}.
     * @return The result of the search in the format defined by param <T>, if authentication fails if the credentials do not validate.
     * @throws CallException if there is an error making the request or the request returns an error
     */
    @Operation
    @Call(uri = TwitterBase.TWITTER_SEARCH_URL + "/search.{format}?q={query}&callback={callback}&lang={lang}&locale={locale}&rpp={rpp}&page={page}&since_id={since_id}&geocode={geocode}&show_user={show_user}")
    public <T> T searchWithJsonCallback(@UriParam("query") String query, @UriParam("callback") String callback, @Optional @UriParam("lang") String lang, @Optional @UriParam("locale") String locale, @Optional @UriParam("rpp") String rpp, @Optional @UriParam("page") String page, @Optional @UriParam("since_id") String sinceId, @Optional @UriParam("geocode") String geocode, @Optional @UriParam("show_user") String showUser) throws CallException;

    /**
     * Returns the top ten topics that are currently trending on Twitter.  The response includes the time of the request,
     * the name of each trend, and the url to the Twitter Search results page for that topic.
     * Format: json
     * Requires Authentication: false
     * API rate limited: 1 call per request
     *
     * @param <T>      The return type class defined in the {@link TwitterBase#setFormat(org.mule.ibeans.twitter.TwitterBase.FORMAT, Class)} or
     *                 {@link TwitterBase#setFormat(org.mule.ibeans.twitter.TwitterBase.FORMAT)} methods or uses the default return type
     *                 {@link TwitterBase#DEFAULT_RETURN_TYPE}. The Twitter Trends API only supports JSON, valid values are {@link String},
     *                 {@link org.mule.module.json.JsonData}.
     * @return The result of the search in the format defined by param <T>, if authentication fails if the credentials do not validate.
     * @throws CallException if there is an error making the request or the request returns an error

     */
    //@Call(uri = TwitterBase.TWITTER_SEARCH_URL + "/trends.json")
    //public <T> T trends() throws CallException;

    /**
     * Returns the current top 10 trending topics on Twitter.  The response includes the time of the request, the name of
     * each trending topic, and query used on Twitter Search results page for that topic.
     * Format: json
     * Requires Authentication: false
     * API rate limited: 1 call per request
     *
     * @param exclude Setting this equal to hashtags will remove all hashtags from the trends list. Optional.
     * @param <T>     The return type class defined in the {@link TwitterBase#setFormat(org.mule.ibeans.twitter.TwitterBase.FORMAT, Class)} or
     *                {@link TwitterBase#setFormat(org.mule.ibeans.twitter.TwitterBase.FORMAT)} methods or uses the default return type
     *                {@link TwitterBase#DEFAULT_RETURN_TYPE}. The Twitter Trends API only supports JSON, valid values are {@link String},
     *                {@link org.mule.module.json.JsonData}.
     * @return The result of the search in the format defined by param <T>, if authentication fails if the credentials do not validate.
     * @throws CallException if there is an error making the request or the request returns an error
     */
    //@Call(uri = TwitterBase.TWITTER_SEARCH_URL + "/trends/current.json?exclude={exclude}")
    //public <T> T trendsCurrent(@Optional @UriParam("exclude") String exclude) throws CallException;

    /**
     * Returns the top 20 trending topics for each hour in a given day.
     * Format: json
     * Requires Authentication: false
     * API rate limited: 1 call per request
     *
     * @param date    Permits specifying a start date for the report. The date should be formatted YYYY-MM-DD. Optional.
     * @param exclude Setting this equal to hashtags will remove all hashtags from the trends list. Optional.
     * @param <T>     The return type class defined in the {@link TwitterBase#setFormat(org.mule.ibeans.twitter.TwitterBase.FORMAT, Class)} or
     *                {@link TwitterBase#setFormat(org.mule.ibeans.twitter.TwitterBase.FORMAT)} methods or uses the default return type
     *                {@link TwitterBase#DEFAULT_RETURN_TYPE}. The Twitter Trends API only supports JSON, valid values are {@link String},
     *                {@link org.mule.module.json.JsonData}.
     * @return The result of the search in the format defined by param <T>, if authentication fails if the credentials do not validate.
     * @throws CallException if there is an error making the request or the request returns an error
     */
    //@Call(uri = TwitterBase.TWITTER_SEARCH_URL + "/trends/daily.json?exclude={exclude}")
    //public <T> T trendsDaily(@Optional @UriParam("date") String date, @Optional @UriParam("exclude") String exclude) throws CallException;

    /**
     * Returns the top 30 trending topics for each day in a given week.
     * Format: json
     * Requires Authentication: false
     * API rate limited: true
     *
     * @param date    Permits specifying a start date for the report. The date should be formatted YYYY-MM-DD. Optional.
     * @param exclude Setting this equal to hashtags will remove all hashtags from the trends list. Optional.
     * @param <T>     The return type class defined in the {@link TwitterBase#setFormat(org.mule.ibeans.twitter.TwitterBase.FORMAT, Class)} or
     *                {@link TwitterBase#setFormat(org.mule.ibeans.twitter.TwitterBase.FORMAT)} methods or uses the default return type
     *                {@link TwitterBase#DEFAULT_RETURN_TYPE}. The Twitter Trends API only supports JSON, valid values are {@link String},
     *                {@link org.mule.module.json.JsonData}.
     * @return The result of the search in the format defined by param <T>, if authentication fails if the credentials do not validate.
     * @throws CallException if there is an error making the request or the request returns an error
     */
    //@Call(uri = TwitterBase.TWITTER_SEARCH_URL + "/trends/weekly.json?exclude={exclude}")
    //public <T> T trendsWeekly(@Optional @UriParam("date") String date, @Optional @UriParam("exclude") String exclude) throws CallException;
}