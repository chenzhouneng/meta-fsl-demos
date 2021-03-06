# Copyright (C) 2014, 2016 Freescale Semiconductor
# Copyright (C) 2015, 2016 O.S. Systems Software LTDA.
# Released under the MIT license (see COPYING.MIT for the terms)
DESCRIPTION = "Package group used by FSL Community to provide graphic packages used \
to test the several hardware accelerated graphics APIs including packages not \
provided by Freescale."
SUMMARY = "FSL Community Package group - tools/gpu/external"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

SOC_GPU_TOOLS_X11 = " \
    mesa-demos \
    glmark2 \
"

SOC_GPU_TOOLS_X11_append_mx6q  = " eglinfo-x11 gtkperf glcompbench"
SOC_GPU_TOOLS_X11_append_mx6dl = " eglinfo-x11 gtkperf glcompbench"
SOC_GPU_TOOLS_X11_append_mx6sx = " eglinfo-x11 gtkperf glcompbench"
SOC_GPU_TOOLS_X11_append_mx6sl = " gtkperf"

SOC_GPU_TOOLS_FB = ""
SOC_GPU_TOOLS_FB_mx6q  = "eglinfo-fb"
SOC_GPU_TOOLS_FB_mx6dl = "eglinfo-fb"
SOC_GPU_TOOLS_FB_mx6sx = "eglinfo-fb"

SOC_GPU_TOOLS_WAYLAND = ""
SOC_GPU_TOOLS_WAYLAND_mx6q  = "mesa-demos glmark2"
SOC_GPU_TOOLS_WAYLAND_mx6dl = "mesa-demos glmark2"
SOC_GPU_TOOLS_WAYLAND_mx6sx = "mesa-demos glmark2"
SOC_GPU_TOOLS_WAYLAND_mx6sl = "mesa-demos"

SOC_GPU_TOOLS_XWAYLAND = ""
SOC_GPU_TOOLS_XWAYLAND_mx6q  = "mesa-demos gtkperf glmark2"
SOC_GPU_TOOLS_XWAYLAND_mx6dl = "mesa-demos gtkperf glmark2"
SOC_GPU_TOOLS_XWAYLAND_mx6sx = "mesa-demos gtkperf glmark2"
SOC_GPU_TOOLS_XWAYLAND_mx6sl = "mesa-demos gtkperf"

RDEPENDS_${PN} = " \
    ${@bb.utils.contains("DISTRO_FEATURES", "x11 wayland", "${SOC_GPU_TOOLS_XWAYLAND}", \
       bb.utils.contains("DISTRO_FEATURES",     "wayland", "${SOC_GPU_TOOLS_WAYLAND}", \
       bb.utils.contains("DISTRO_FEATURES",         "x11", "${SOC_GPU_TOOLS_X11}", \
                                                           "${SOC_GPU_TOOLS_FB}", d), d), d)} \
"
