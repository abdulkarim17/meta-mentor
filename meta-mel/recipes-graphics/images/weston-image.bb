SUMMARY = "Wayland/Weston image based on core-image-weston image recipe from Poky"

IMAGE_FEATURES += "splash package-management hwcodecs"

LICENSE = "MIT"

inherit core-image distro_features_check

REQUIRED_DISTRO_FEATURES = "wayland"

CORE_IMAGE_BASE_INSTALL += "weston weston-init weston-examples"

# We want libgcc to always be available, even if nothing needs it, as its size
# is minimal, and it's often needed by third party (or QA) binaries
IMAGE_INSTALL_append_mel = " libgcc"

IMAGE_FEATURES .= "${@base_contains('COMBINED_FEATURES', 'alsa', ' tools-audio', '', d)}"
IMAGE_INSTALL += " quota connman"
