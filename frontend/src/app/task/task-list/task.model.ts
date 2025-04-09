export interface Task {
  id: number;
  title: string;
  description: string;
  status: string;  // TO_DO, IN_PROGRESS, DONE
  createdAt: string;  // ISO string format (e.g., "2025-04-09T12:30:00")
}
