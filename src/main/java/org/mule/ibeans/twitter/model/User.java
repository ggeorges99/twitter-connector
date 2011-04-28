/*
 * $Id: User.java 297 2011-04-12 00:12:01Z dzapata $
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSource, Inc.  All rights reserved.  http://www.mulesource.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.ibeans.twitter.model;

import javax.xml.bind.annotation.XmlElement;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * A object representation of the User data used by Twitter.  This object can be used to bind to XMl and JSON
 */
public class User
{
    @JsonProperty("profile_sidebar_fill_color")
    @XmlElement(name = "profile_sidebar_fill_color")
    private String profileSidebarFillColor;
    @JsonProperty("description")
    @XmlElement(name = "description")
    private String description;
    @JsonProperty("screen_name")
    @XmlElement(name = "screen_name")
    private String screenName;
    @JsonProperty("followers_count")
    @XmlElement(name = "followers_count")
    private int followersCount;
    @JsonProperty("following")
    @XmlElement(name = "following")
    private boolean following;
    @JsonProperty("statuses_count")
    @XmlElement(name = "statuses_count")
    private int statusesCount;
    @JsonProperty("time_zone")
    @XmlElement(name = "time_zone")
    private String timezone;
    @JsonProperty("profile_sidebar_border_color")
    @XmlElement(name = "profile_sidebar_border_color")
    private String profileSidebarBorderColor;
    @JsonProperty("friends_count")
    @XmlElement(name = "friends_count")
    private int friendsCount;
    @JsonProperty("notifications")
    @XmlElement(name = "notifications")
    private boolean notifications;
    @JsonProperty("favourites_count")
    @XmlElement(name = "favourites_count")
    private int favouritesCount;
    @JsonProperty("profile_text_color")
    @XmlElement(name = "profile_text_color")
    private String profiletextColor;
    @JsonProperty("url")
    @XmlElement(name = "url")
    private String url;
    @JsonProperty("profile_background_image_url")
    @XmlElement(name = "profile_background_image_url")
    private String profileBackgroundImageUrl;
    @JsonProperty("geo_enabled")
    @XmlElement(name = "geo_enabled")
    private boolean geoEnabled;
    @JsonProperty("profile_link_color")
    @XmlElement(name = "profile_link_color")
    private String profileLinkColor;
    @JsonProperty("protected")
    @XmlElement(name = "protected")
    private boolean protectedUser;
    @JsonProperty("profile_background_tile")
    @XmlElement(name = "profile_background_tile")
    private boolean profileBackgroundTile;
    @JsonProperty("created_at")
    @XmlElement(name = "created_at")
    private String createdAt;
    @JsonProperty("location")
    @XmlElement(name = "location")
    private String location;
    @JsonProperty("name")
    @XmlElement(name = "name")
    private String name;
    @JsonProperty("verified")
    @XmlElement(name = "verified")
    private boolean verified;
    @JsonProperty("profile_background_color")
    @XmlElement(name = "profile_background_color")
    private String profileBackgroundColor;
    @JsonProperty("profile_image_url")
    @XmlElement(name = "profile_image_url")
    private String profileImageUrl;
    @JsonProperty("id")
    @XmlElement(name = "id")
    private String id;
    @JsonProperty("utc_offset")
    @XmlElement(name = "utc_offset")
    private String utcOffset;

    @JsonProperty("default_profile")
    @XmlElement(name = "default_profile")
    private boolean defaultProfile;

    @JsonProperty("default_profile_image")
    @XmlElement(name = "default_profile_image")
    private boolean defaultProfileImage;    
    
    //New properties added Jan 1, 2010
    @JsonProperty("contributors_enabled")
    @XmlElement(name = "contributors_enabled")
    private boolean contributorsEnabled;
    @JsonProperty("lang")
    @XmlElement(name = "lang")
    private String lang;

    //New properties added Jan 23, 2011
    @JsonProperty("follow_request_sent")
    @XmlElement(name = "follow_request_sent")
    private boolean followRequestSent;

    @JsonProperty("show_all_inline_media")
    @XmlElement(name = "show_all_inline_media")
    private boolean showAllInlineMedia;

    @JsonProperty("listed_count")
    @XmlElement(name = "listed_count")
    private int listedCount;

    //Ignored, model already handles strings
    @JsonProperty
    private String id_str;

    @JsonProperty("profile_use_background_image")
    @XmlElement(name = "profile_use_background_image")
    private boolean profileUseBackgroundImage;

    @JsonProperty("is_translator")
    @XmlElement(name = "is_translator")
    private boolean isTranslator;


    public boolean isTranslator()
    {
        return isTranslator;
    }

    public void setTranslator(boolean translator)
    {
        isTranslator = translator;
    }

    public boolean isProfileUseBackgroundImage()
    {
        return profileUseBackgroundImage;
    }

    public void setProfileUseBackgroundImage(boolean profileUseBackgroundImage)
    {
        this.profileUseBackgroundImage = profileUseBackgroundImage;
    }

    public int getListedCount()
    {
        return listedCount;
    }

    public void setListedCount(int listedCount)
    {
        this.listedCount = listedCount;
    }

    public boolean isShowAllInlineMedia()
    {
        return showAllInlineMedia;
    }

    public void setShowAllInlineMedia(boolean showAllInlineMedia)
    {
        this.showAllInlineMedia = showAllInlineMedia;
    }

    public boolean isFollowRequestSent()
    {
        return followRequestSent;
    }

    public void setFollowRequestSent(boolean followRequestSent)
    {
        this.followRequestSent = followRequestSent;
    }

    public String getProfileSidebarFillColor()
    {
        return profileSidebarFillColor;
    }

    public void setProfileSidebarFillColor(String profileSidebarFillColor)
    {
        this.profileSidebarFillColor = profileSidebarFillColor;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getScreenName()
    {
        return screenName;
    }

    public void setScreenName(String screenName)
    {
        this.screenName = screenName;
    }

    public int getFollowersCount()
    {
        return followersCount;
    }

    public void setFollowersCount(int followersCount)
    {
        this.followersCount = followersCount;
    }

    public boolean isFollowing()
    {
        return following;
    }

    public void setFollowing(boolean following)
    {
        this.following = following;
    }

    public int getStatusesCount()
    {
        return statusesCount;
    }

    public void setStatusesCount(int statusesCount)
    {
        this.statusesCount = statusesCount;
    }

    public String getTimezone()
    {
        return timezone;
    }

    public void setTimezone(String timezone)
    {
        this.timezone = timezone;
    }

    public String getProfileSidebarBorderColor()
    {
        return profileSidebarBorderColor;
    }

    public void setProfileSidebarBorderColor(String profileSidebarBorderColor)
    {
        this.profileSidebarBorderColor = profileSidebarBorderColor;
    }

    public int getFriendsCount()
    {
        return friendsCount;
    }

    public void setFriendsCount(int friendsCount)
    {
        this.friendsCount = friendsCount;
    }

    public boolean isNotifications()
    {
        return notifications;
    }

    public void setNotifications(boolean notifications)
    {
        this.notifications = notifications;
    }

    public int getFavouritesCount()
    {
        return favouritesCount;
    }

    public void setFavouritesCount(int favouritesCount)
    {
        this.favouritesCount = favouritesCount;
    }

    public String getProfiletextColor()
    {
        return profiletextColor;
    }

    public void setProfiletextColor(String profiletextColor)
    {
        this.profiletextColor = profiletextColor;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getProfileBackgroundImageUrl()
    {
        return profileBackgroundImageUrl;
    }

    public void setProfileBackgroundImageUrl(String profileBackgroundImageUrl)
    {
        this.profileBackgroundImageUrl = profileBackgroundImageUrl;
    }

    public boolean isGeoEnabled()
    {
        return geoEnabled;
    }

    public void setGeoEnabled(boolean geoEnabled)
    {
        this.geoEnabled = geoEnabled;
    }

    public String getProfileLinkColor()
    {
        return profileLinkColor;
    }

    public void setProfileLinkColor(String profileLinkColor)
    {
        this.profileLinkColor = profileLinkColor;
    }

    public boolean isProtectedUser()
    {
        return protectedUser;
    }

    public void setProtectedUser(boolean protectedUser)
    {
        this.protectedUser = protectedUser;
    }

    public boolean isProfileBackgroundTile()
    {
        return profileBackgroundTile;
    }

    public void setProfileBackgroundTile(boolean profileBackgroundTile)
    {
        this.profileBackgroundTile = profileBackgroundTile;
    }

    public String getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(String createdAt)
    {
        this.createdAt = createdAt;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public boolean isVerified()
    {
        return verified;
    }

    public void setVerified(boolean verified)
    {
        this.verified = verified;
    }

    public String getProfileBackgroundColor()
    {
        return profileBackgroundColor;
    }

    public void setProfileBackgroundColor(String profileBackgroundColor)
    {
        this.profileBackgroundColor = profileBackgroundColor;
    }

    public String getProfileImageUrl()
    {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl)
    {
        this.profileImageUrl = profileImageUrl;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getUtcOffset()
    {
        return utcOffset;
    }

    public void setUtcOffset(String utcOffset)
    {
        this.utcOffset = utcOffset;
    }

    public boolean isContributorsEnabled()
    {
        return contributorsEnabled;
    }

    public void setContributorsEnabled(boolean contributorsEnabled)
    {
        this.contributorsEnabled = contributorsEnabled;
    }

    public String getLang()
    {
        return lang;
    }

    public void setLang(String lang)
    {
        this.lang = lang;
    }

    public boolean isDefaultProfile()
    {
        return defaultProfile;
    }

    public void setDefaultProfile(boolean defaultProfile)
    {
        this.defaultProfile = defaultProfile;
    }

    public boolean isDefaultProfileImage()
    {
        return defaultProfileImage;
    }

    public void setDefaultProfileImage(boolean defaultProfileImage)
    {
        this.defaultProfileImage = defaultProfileImage;
    }
}