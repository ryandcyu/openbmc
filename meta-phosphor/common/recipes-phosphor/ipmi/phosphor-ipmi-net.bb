SUMMARY = "Phosphor Network IPMI Daemon"
DESCRIPTION = "Daemon to support IPMI protocol over network"
HOMEPAGE = "https://github.com/openbmc/phosphor-net-ipmid"
PR = "r1"

inherit autotools pkgconfig
inherit obmc-phosphor-license
inherit obmc-phosphor-systemd

DEPENDS += "autoconf-archive-native"
DEPENDS += "phosphor-mapper"
DEPENDS += "systemd"
DEPENDS += "phosphor-ipmi-host"
RDEPENDS_${PN} += "libmapper"
RDEPENDS_${PN} += "libsystemd"
PROVIDES += "virtual/obmc-net-ipmi"
RPROVIDES_${PN} += "virtual-obmc-net-ipmi"

SRC_URI += "git://github.com/openbmc/phosphor-net-ipmid"
SRCREV = "9c60a58eb8643365982e83a96a922dd06bfd241a"

S = "${WORKDIR}/git"

SYSTEMD_SERVICE_${PN} = " \
        ${PN}.service \
        ${PN}.socket \
        "
