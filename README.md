Replicating Kubernetes Ingress locally using Nginx

<b>Sample Application:</b>
<ul>
    <li>my-bank-nginx-proxy 
        <ul>
            <li>runs on port 80</li>
            <li>nginx app having html page - `index.yaml`</li>
            <li>has 2 links: one pointing to customer app (8080) and other to employee app (8081)</li>
            <li>Link to customer and employee apps is via relative path and url is not mentioned in index.html as nginx can handle it</li>
        </ul>
    </li>
    <li>my-bank-customer - runs on port 8080</li>
    <li>my-bank-employee - runs on port 8081</li>
</ul>

Steps to run :

1. replace <PATH_TO_REPO_ON_LOCAL> in my-bank/docker-compose.yaml
2. run docker-compose.yaml using <code>docker-compose up</code>
3. once up, access app at http://localhost:80 (app can also be accessed at my-bank.com if it is added in /etc/hosts)
4. upon clicking on `customer portal`, app gets redirected to port 8080 via nginx proxy we created
4. upon clicking on `employee portal`, app gets redirected to port 8081 via nginx proxy we created