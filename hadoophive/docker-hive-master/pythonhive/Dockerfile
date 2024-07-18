FROM bde2020/hadoop-base:2.0.0-hadoop3.2.1-java8

RUN apt update
RUN apt install -y wget
RUN wget https://repo.anaconda.com/miniconda/Miniconda3-latest-Linux-x86_64.sh
RUN bash Miniconda3-latest-Linux-x86_64.sh -b
RUN mkdir -p /root/.conda
ENV PATH="/root/miniconda3/bin:${PATH}"

RUN apt install -y libsasl2-dev
RUN apt install -y gcc
RUN apt install -y g++
RUN apt install -y libsasl2-modules libsasl2-dev
RUN pip install PyHive
RUN pip install sasl
RUN pip install thrift
RUN pip install thrift-sasl
COPY ./app /home/app
ADD run.sh /tmp/run.sh
RUN chmod +x /tmp/run.sh

CMD ["/tmp/run.sh"]
