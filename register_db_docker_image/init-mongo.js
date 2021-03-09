db.createUser(
    {
        user: "admin",
        pwd: "api_pass",
        roles : [
            {
                role: "readWrite",
                db: "employee"
            }
        ]
    }
)