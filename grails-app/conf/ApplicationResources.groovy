/*
 * Copyright (c) 2013, IT Services, Stockholm University
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * Neither the name of Stockholm University nor the names of its contributors
 * may be used to endorse or promote products derived from this software
 * without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

modules = {
  application {
    resource url:'js/application.js'
  }

  jQuery {
    resource url:'js/lib/jquery-1.10.2.min.js'
  }

  use_cases {
    dependsOn(['jQuery'])
    resource url:'js/use_cases.js'
  }

  admin {
    dependsOn(['jQuery'])
    resource url:'css/app/app_admin.css'
    resource url:'js/admin.js'
  }

  css {

    resource url:'css/layout.css'
    resource url:'css/resources.css'
    resource url:'css/typography.css'
    resource url:'css/forms.css'
    resource url:'css/element-styles.css'
    resource url:'css/webapps.css'
    resource url:'css/profile.css'
    resource url:'css/print.css', attrs:[media:'print']
    resource url:'css/signuptool.css'
  }

  responsive {
    dependsOn(['css'])
    resource url:'css/responsive.css'
    resource url:'js/responsiveScripting.js'
  }
}
