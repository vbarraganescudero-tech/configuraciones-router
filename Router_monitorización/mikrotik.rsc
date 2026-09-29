# 2026-09-29 15:18:33 by RouterOS 7.24.2
# system id = S6ovkJXeX6E
#
/interface ethernet
set [ find default-name=ether1 ] disable-running-check=no
set [ find default-name=ether2 ] disable-running-check=no
set [ find default-name=ether3 ] disable-running-check=no
set [ find default-name=ether4 ] disable-running-check=no
set [ find default-name=ether5 ] disable-running-check=no
set [ find default-name=ether6 ] disable-running-check=no
set [ find default-name=ether7 ] disable-running-check=no
set [ find default-name=ether8 ] disable-running-check=no
set [ find default-name=ether9 ] disable-running-check=no
set [ find default-name=ether10 ] disable-running-check=no
/ip address
add address=192.168.1.2/24 interface=ether2 network=192.168.1.0
add address=192.168.122.2/24 interface=ether3 network=192.168.122.0
/ip dhcp-client
# Interface not active
add interface=ether1 name=client1
/ip route
add dst-address=192.168.8.0/24 gateway=192.168.1.6
add dst-address=192.168.7.0/24 gateway=192.168.1.6
add dst-address=192.168.3.0/24 gateway=192.168.1.6
add dst-address=192.168.2.0/24 gateway=192.168.1.6
add dst-address=0.0.0.0/0 gateway=192.168.5.1
add dst-address=0.0.0.0/0 gateway=192.168.5.1
add dst-address=0.0.0.0/0 gateway=192.168.122.1
/snmp
set enabled=yes
