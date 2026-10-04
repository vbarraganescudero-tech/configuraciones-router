interfaces {
    ethernet eth0 {
        address "192.168.1.5/24"
        address "192.168.122.5/24"
        hw-id "0c:9a:d7:91:00:00"
    }
    ethernet eth1 {
        address "192.168.1.4/24"
        address "192.168.1.5/24"
        hw-id "0c:9a:d7:91:00:01"
    }
    ethernet eth2 {
        hw-id "0c:9a:d7:91:00:02"
    }
    ethernet eth3 {
        hw-id "0c:9a:d7:91:00:03"
    }
    ethernet eth4 {
        hw-id "0c:9a:d7:91:00:04"
    }
    ethernet eth5 {
        hw-id "0c:9a:d7:91:00:05"
    }
    ethernet eth6 {
        hw-id "0c:9a:d7:91:00:06"
    }
    ethernet eth7 {
        hw-id "0c:9a:d7:91:00:07"
    }
    ethernet eth8 {
        hw-id "0c:9a:d7:91:00:08"
    }
    ethernet eth9 {
        hw-id "0c:9a:d7:91:00:09"
    }
    loopback lo {
    }
}
protocols {
    static {
        route 0.0.0.0/0 {
            next-hop 192.168.122.1 {
            }
        }
        route 192.168.2.0/24 {
            next-hop 192.168.1.6 {
            }
        }
        route 192.168.3.0/24 {
            next-hop 192.168.1.6 {
            }
        }
    }
}
service {
    ntp {
        allow-client {
            address "127.0.0.0/8"
            address "169.254.0.0/16"
            address "10.0.0.0/8"
            address "172.16.0.0/12"
            address "192.168.0.0/16"
            address "::1/128"
            address "fe80::/10"
            address "fc00::/7"
        }
        server time1.vyos.net {
        }
        server time2.vyos.net {
        }
        server time3.vyos.net {
        }
    }
    snmp {
        community public {
            authorization "ro"
        }
    }
    ssh {
        port "22"
    }
}
system {
    config-management {
        commit-revisions "100"
    }
    console {
        device ttyS0 {
            speed "115200"
        }
    }
    host-name "vyos"
    login {
        tacacs {
            server 192.168.122.1 {
                key "Victortk123"
                port "49"
            }
            source-address "192.168.122.5"
        }
        user vyos {
            authentication {
                encrypted-password "$6$QxPS.uk6mfo$9QBSo8u1FkH16gMyAVhus6fU3LOzvLR9Z9.82m3tiHFAxTtIkhaZSWssSgzt4v4dGAL8rhVQxTg0oAG9/q11h/"
                plaintext-password ""
            }
        }
    }
    option {
        reboot-on-upgrade-failure "5"
    }
    syslog {
        local {
            facility all {
                level "info"
            }
            facility local7 {
                level "debug"
            }
        }
    }
    task-scheduler {
        task copia-config {
            executable {
                path "/config/scripts/copia-config.sh"
            }
            interval "1m"
        }
    }
}


// Warning: Do not remove the following line.
// vyos-config-version: "bgp@6:broadcast-relay@1:cluster@2:config-management@1:conntrack@6:conntrack-sync@2:container@3:dhcp-relay@2:dhcp-server@11:dhcpv6-server@6:dns-dynamic@4:dns-forwarding@4:firewall@20:flow-accounting@3:https@7:ids@2:interfaces@34:ipoe-server@4:ipsec@14:isis@3:l2tp@9:lldp@3:mdns@1:monitoring@2:nat@8:nat66@3:nhrp@1:ntp@3:openconnect@3:openvpn@5:ospf@2:pim@1:policy@8:pppoe-server@12:pptp@5:qos@3:quagga@12:reverse-proxy@3:rip@1:rpki@2:salt@1:snmp@3:ssh@3:sstp@6:system@31:vpp@6:vrf@4:vrrp@4:vyos-accel-ppp@2:wanloadbalance@4:webproxy@2"
// Release version: 1.5.0
