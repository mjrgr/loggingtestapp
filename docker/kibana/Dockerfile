#########################################################
# Kibana Image without X-Pack
#########################################################
FROM docker.elastic.co/kibana/kibana:5.6.2

MAINTAINER Mehdi JrGr

RUN /usr/share/kibana/bin/kibana-plugin remove x-pack
RUN /usr/share/kibana/bin/kibana 2>&1 | grep -m 1 "Optimization of .* complete in .* seconds"