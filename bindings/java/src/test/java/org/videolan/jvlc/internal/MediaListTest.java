/*****************************************************************************
 * MediaListTest.java: VLC Java Bindings
 *****************************************************************************
 * Copyright (C) 1998-2008 the VideoLAN team
 *
 * Authors: Filippo Carone <filippo@carone.org>
 *
 *
 * $Id $
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111, USA.
 *****************************************************************************/

package org.videolan.jvlc.internal;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.videolan.jvlc.internal.LibVlc.LibVlcInstance;
import org.videolan.jvlc.internal.LibVlc.LibVlcMediaDescriptor;
import org.videolan.jvlc.internal.LibVlc.LibVlcMediaList;
import org.videolan.jvlc.internal.LibVlc.libvlc_exception_t;



public class MediaListTest
{
    private LibVlc libvlc = LibVlc.INSTANCE;
    private LibVlcInstance libvlcInstance;
    
    @Before
    public void testSetup()
    {
        libvlc_exception_t exception = new libvlc_exception_t();
        libvlcInstance = libvlc.libvlc_new(0, new String[] {}, exception );
    }
    
    @After
    public void tearDown()
    {
        libvlc.libvlc_release(libvlcInstance);
    }
    
    @Test
    public void mediaListNew()
    {
        libvlc_exception_t exception = new libvlc_exception_t();
        LibVlcMediaList mediaList = libvlc.libvlc_media_list_new(libvlcInstance, exception);
        Assert.assertNotNull(mediaList);
        Assert.assertEquals(0, exception.raised);
    }
    
    @Test
    public void mediaListAddMediaDescriptor()
    {
        libvlc_exception_t exception = new libvlc_exception_t();
        LibVlcMediaList mediaList = libvlc.libvlc_media_list_new(libvlcInstance, exception);
        String mrl = this.getClass().getResource("/raffa_voice.ogg").getPath();
        LibVlcMediaDescriptor libvlc_media_descriptor = libvlc.libvlc_media_descriptor_new(libvlcInstance, mrl, exception);
        libvlc.libvlc_media_list_add_media_descriptor(mediaList, libvlc_media_descriptor , exception);
        Assert.assertEquals(0, exception.raised);
    }
}
