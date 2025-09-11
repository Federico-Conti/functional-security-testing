# ZAP

docker pull zaproxy/zap-stable
 2158  docker run -v $(pwd):/zap/wrk/:rw --network="host" zaproxy/zap-stable zap-baseline.py -t http://localhost:8088 -r scan-report.html
 2159  docker run -v $(pwd):/zap/wrk/:rw --network="host" zaproxy/zap-stable zap-baseline.py -t http://localhost:8088 -r zap.sh

